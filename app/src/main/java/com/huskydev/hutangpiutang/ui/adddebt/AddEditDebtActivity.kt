package com.huskydev.hutangpiutang.ui.adddebt

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.datepicker.MaterialDatePicker
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.databinding.ActivityAddEditDebtBinding
import com.huskydev.hutangpiutang.reminder.ReminderScheduler
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil
import com.huskydev.hutangpiutang.util.ViewModelFactory

class AddEditDebtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditDebtBinding
    private lateinit var viewModel: AddEditDebtViewModel

    private var editDebtId: Long? = null
    private var dateCreatedMillis: Long = System.currentTimeMillis()
    private var dueDateMillis: Long? = null
    private var isFormatting = false // guard untuk TextWatcher agar tidak loop

    companion object {
        const val EXTRA_DEBT_ID = "extra_debt_id"
    }

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (!granted) {
                binding.switchReminder.isChecked = false
                Toast.makeText(this, R.string.notification_disabled_warning, Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditDebtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as HutangPiutangApp
        viewModel = ViewModelProvider(this, ViewModelFactory {
            AddEditDebtViewModel(app.contactRepository, app.debtRepository, app.executor)
        })[AddEditDebtViewModel::class.java]

        editDebtId = intent.getLongExtra(EXTRA_DEBT_ID, -1).takeIf { it != -1L }

        setupToolbar()
        setupAmountFormatter()
        setupDatePickers()
        setupReminderToggle()
        setupSaveButton()
        observeData()

        // Edit mode: load existing data
        editDebtId?.let { viewModel.loadDebt(it) }

        // Set default date created
        binding.etDateCreated.setText(DateUtil.formatDate(dateCreatedMillis))
    }

    override fun onResume() {
        super.onResume()
        checkNotificationPermissionStatus()
    }

    private fun setupToolbar() {
        binding.toolbar.title = if (editDebtId != null)
            getString(R.string.edit_debt_title) else getString(R.string.add_debt_title)
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupAmountFormatter() {
        binding.etAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (isFormatting) return
                isFormatting = true
                val formatted = CurrencyFormatter.formatRaw(s.toString())
                binding.etAmount.setText(formatted)
                binding.etAmount.setSelection(formatted.length)
                isFormatting = false
            }
        })
    }

    private fun setupDatePickers() {
        binding.etDateCreated.setOnClickListener {
            showDatePicker("Tanggal Transaksi", dateCreatedMillis) { millis ->
                dateCreatedMillis = millis
                binding.etDateCreated.setText(DateUtil.formatDate(millis))
                checkDueDateWarning()
            }
        }

        binding.etDueDate.setOnClickListener {
            showDatePicker("Tanggal Jatuh Tempo", dueDateMillis ?: System.currentTimeMillis()) { millis ->
                dueDateMillis = millis
                binding.etDueDate.setText(DateUtil.formatDate(millis))
                checkDueDateWarning()
            }
        }

        // Clear due date when end icon is tapped
        binding.tilDueDate.setEndIconOnClickListener {
            dueDateMillis = null
            binding.etDueDate.text?.clear()
            binding.tvDueDateWarning.visibility = android.view.View.GONE
        }
    }

    private fun showDatePicker(title: String, initialSelection: Long, onDateSelected: (Long) -> Unit) {
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(title)
            .setSelection(initialSelection)
            .build()

        picker.addOnPositiveButtonClickListener { millis ->
            onDateSelected(millis)
        }

        picker.show(supportFragmentManager, "date_picker")
    }

    private fun checkDueDateWarning() {
        val due = dueDateMillis ?: return
        binding.tvDueDateWarning.visibility =
            if (due < dateCreatedMillis) android.view.View.VISIBLE else android.view.View.GONE
    }

    private fun setupReminderToggle() {
        binding.switchReminder.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Request POST_NOTIFICATIONS permission on Android 13+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }
            }
        }
    }

    private fun checkNotificationPermissionStatus() {
        val notifEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled()
        if (!notifEnabled && binding.switchReminder.isChecked) {
            binding.switchReminder.isChecked = false
        }
        binding.tvNotifWarning.visibility =
            if (!notifEnabled) android.view.View.VISIBLE else android.view.View.GONE
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {
            if (validate()) {
                val name = binding.etContactName.text.toString().trim()
                val phone = binding.etContactPhone.text.toString().trim().ifEmpty { null }
                val type = if (binding.rbPiutang.isChecked) DebtType.PIUTANG else DebtType.HUTANG
                val amount = CurrencyFormatter.parse(binding.etAmount.text.toString())
                val desc = binding.etDescription.text.toString().trim().ifEmpty { null }
                val reminderEnabled = binding.switchReminder.isChecked

                // Calculate reminder datetime
                val prefs = getSharedPreferences(HutangPiutangApp.PREFS_NAME, MODE_PRIVATE)
                val leadDays = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_LEAD_DAYS, HutangPiutangApp.DEFAULT_LEAD_DAYS)
                val reminderHour = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_HOUR, HutangPiutangApp.DEFAULT_REMINDER_HOUR)

                val reminderDatetime = if (reminderEnabled && dueDateMillis != null) {
                    DateUtil.calculateReminderTime(dueDateMillis!!, leadDays, reminderHour)
                } else null

                viewModel.save(
                    contactName = name,
                    contactPhone = phone,
                    type = type,
                    amount = amount,
                    description = desc,
                    dateCreated = dateCreatedMillis,
                    dueDate = dueDateMillis,
                    reminderEnabled = reminderEnabled,
                    reminderDatetime = reminderDatetime,
                    editDebtId = editDebtId
                )
            }
        }
    }

    private fun validate(): Boolean {
        var valid = true

        // Contact name
        if (binding.etContactName.text.toString().trim().isEmpty()) {
            binding.tilContactName.error = getString(R.string.error_name_empty)
            valid = false
        } else {
            binding.tilContactName.error = null
        }

        // Amount
        val amount = CurrencyFormatter.parse(binding.etAmount.text.toString())
        if (amount <= 0) {
            binding.tilAmount.error = getString(R.string.error_amount_zero)
            valid = false
        } else {
            binding.tilAmount.error = null
        }

        return valid
    }

    private fun observeData() {
        // Edit mode: populate form with existing data
        viewModel.existingDebt.observe(this) { debt ->
            if (debt == null) return@observe
            if (debt.type == DebtType.PIUTANG) binding.rbPiutang.isChecked = true
            else binding.rbHutang.isChecked = true

            binding.etAmount.setText(CurrencyFormatter.formatRaw(debt.originalAmount.toString()))
            binding.etDescription.setText(debt.description ?: "")

            dateCreatedMillis = debt.dateCreated
            binding.etDateCreated.setText(DateUtil.formatDate(debt.dateCreated))

            if (debt.dueDate != null) {
                dueDateMillis = debt.dueDate
                binding.etDueDate.setText(DateUtil.formatDate(debt.dueDate))
            }

            binding.switchReminder.isChecked = debt.reminderEnabled
        }

        viewModel.existingContact.observe(this) { contact ->
            if (contact == null) return@observe
            binding.etContactName.setText(contact.name)
            binding.etContactPhone.setText(contact.phone ?: "")
        }

        // Save result
        viewModel.saveResult.observe(this) { result ->
            when (result) {
                is AddEditDebtViewModel.SaveResult.Success -> {
                    val debt = result.debt

                    // Reminder handling
                    if (editDebtId != null) {
                        // Edit mode: ALWAYS cancel first, then reschedule if needed
                        ReminderScheduler.cancel(this, result.debtId)
                    }
                    if (debt.reminderEnabled && debt.reminderDatetime != null) {
                        ReminderScheduler.schedule(this, result.debtId, debt.reminderDatetime)
                    }

                    Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show()
                    finish()
                }
                is AddEditDebtViewModel.SaveResult.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
