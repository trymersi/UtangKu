package com.huskydev.hutangpiutang.ui.detail

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.databinding.ActivityDebtDetailBinding
import com.huskydev.hutangpiutang.reminder.ReminderScheduler
import com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtActivity
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil
import com.huskydev.hutangpiutang.util.ViewModelFactory

class DebtDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDebtDetailBinding
    private lateinit var viewModel: DebtDetailViewModel
    private lateinit var paymentAdapter: PaymentHistoryAdapter

    private var currentDebt: Debt? = null

    companion object {
        const val EXTRA_DEBT_ID = "extra_debt_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebtDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as HutangPiutangApp
        viewModel = ViewModelProvider(this, ViewModelFactory {
            DebtDetailViewModel(app.debtRepository, app.contactRepository, app.paymentRepository, app.executor)
        })[DebtDetailViewModel::class.java]

        val debtId = intent.getLongExtra(EXTRA_DEBT_ID, -1)
        if (debtId == -1L) {
            finish()
            return
        }

        setupToolbar()
        setupPaymentList()
        setupButtons(debtId)
        observeData(debtId)
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupPaymentList() {
        paymentAdapter = PaymentHistoryAdapter()
        binding.recyclerPayments.layoutManager = LinearLayoutManager(this)
        binding.recyclerPayments.adapter = paymentAdapter
    }

    private fun setupButtons(debtId: Long) {
        // Add payment
        binding.btnAddPayment.setOnClickListener {
            val debt = currentDebt ?: return@setOnClickListener
            if (debt.status == DebtStatus.LUNAS) return@setOnClickListener

            val sheet = PaymentBottomSheet.newInstance(debt.remainingAmount)
            sheet.setOnPaymentSubmitListener { amount, date, note ->
                viewModel.addPayment(debtId, amount, date, note)
            }
            sheet.show(supportFragmentManager, "payment")
        }

        // Mark paid
        binding.btnMarkPaid.setOnClickListener {
            val debt = currentDebt ?: return@setOnClickListener
            if (debt.status == DebtStatus.LUNAS) return@setOnClickListener

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.confirm_mark_paid_title)
                .setMessage(getString(R.string.confirm_mark_paid_message,
                    CurrencyFormatter.format(debt.remainingAmount)))
                .setPositiveButton(R.string.btn_yes_mark_paid) { _, _ ->
                    viewModel.markAsPaid(debtId)
                }
                .setNegativeButton(R.string.cancel, null)
                .show()
        }

        // Edit
        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, AddEditDebtActivity::class.java)
            intent.putExtra(AddEditDebtActivity.EXTRA_DEBT_ID, debtId)
            startActivity(intent)
        }

        // Delete
        binding.btnDelete.setOnClickListener {
            val debt = currentDebt ?: return@setOnClickListener
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.confirm_delete_debt_title)
                .setMessage(R.string.confirm_delete_debt_message)
                .setPositiveButton(R.string.btn_yes_delete) { _, _ ->
                    // Cancel reminder first
                    ReminderScheduler.cancel(this, debt.id)
                    viewModel.deleteDebt(debt)
                }
                .setNegativeButton(R.string.cancel, null)
                .show()
        }
    }

    private fun observeData(debtId: Long) {
        // Debt
        viewModel.getDebtLive(debtId).observe(this) { debt ->
            if (debt == null) return@observe
            currentDebt = debt
            viewModel.loadContact(debt.contactId)
            bindDebt(debt)
        }

        // Payments
        viewModel.getPayments(debtId).observe(this) { payments ->
            paymentAdapter.submitList(payments)
            binding.tvNoPayments.visibility = if (payments.isEmpty()) View.VISIBLE else View.GONE
            binding.recyclerPayments.visibility = if (payments.isEmpty()) View.GONE else View.VISIBLE
        }

        // Contact
        viewModel.contact.observe(this) { contact ->
            if (contact == null) return@observe
            binding.tvContactName.text = contact.name
            binding.tvAvatarInitial.text = contact.name.first().uppercase()

            val bg = binding.avatarCircle.background
            if (bg is GradientDrawable) {
                bg.setColor(contact.avatarColor)
            }

            // Show contact action buttons if phone available
            if (!contact.phone.isNullOrBlank()) {
                binding.contactActions.visibility = View.VISIBLE
                binding.btnCall.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.phone}"))
                    startActivity(intent)
                }
                binding.btnMessage.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:${contact.phone}"))
                    startActivity(intent)
                }
            }
        }

        // Action results
        viewModel.actionResult.observe(this) { result ->
            when (result) {
                is DebtDetailViewModel.ActionResult.PaymentAdded -> {
                    Toast.makeText(this, "Pembayaran dicatat", Toast.LENGTH_SHORT).show()
                }
                is DebtDetailViewModel.ActionResult.MarkedPaid -> {
                    // Cancel alarm when status becomes LUNAS
                    ReminderScheduler.cancel(this, result.debtId)
                    Toast.makeText(this, "Ditandai lunas", Toast.LENGTH_SHORT).show()
                }
                is DebtDetailViewModel.ActionResult.Deleted -> {
                    Toast.makeText(this, "Catatan dihapus", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    private fun bindDebt(debt: Debt) {
        // Type
        if (debt.type == DebtType.PIUTANG) {
            binding.tvType.text = getString(R.string.piutang_label)
            binding.tvType.setTextColor(getColor(R.color.piutang_green))
        } else {
            binding.tvType.text = getString(R.string.hutang_label)
            binding.tvType.setTextColor(getColor(R.color.hutang_red))
        }

        // Amounts
        binding.tvOriginalAmount.text = CurrencyFormatter.format(debt.originalAmount)
        binding.tvRemainingAmount.text = CurrencyFormatter.format(debt.remainingAmount)
        binding.tvRemainingAmount.setTextColor(
            if (debt.status == DebtStatus.LUNAS) getColor(R.color.lunas_gray)
            else if (debt.type == DebtType.PIUTANG) getColor(R.color.piutang_green)
            else getColor(R.color.hutang_red)
        )

        // Progress
        val paid = debt.originalAmount - debt.remainingAmount
        val progress = if (debt.originalAmount > 0) (paid * 100 / debt.originalAmount).toInt() else 0
        binding.progressBar.progress = progress

        // Status
        when (debt.status) {
            DebtStatus.BELUM_LUNAS -> {
                binding.tvStatus.text = getString(R.string.status_belum_lunas)
                binding.tvStatus.setTextColor(getColor(R.color.due_soon_orange))
                binding.tvStatus.setBackgroundColor(getColor(R.color.due_soon_orange_light))
            }
            DebtStatus.SEBAGIAN -> {
                binding.tvStatus.text = getString(R.string.status_sebagian)
                binding.tvStatus.setTextColor(getColor(R.color.primary))
                binding.tvStatus.setBackgroundColor(getColor(R.color.surface_variant))
            }
            DebtStatus.LUNAS -> {
                binding.tvStatus.text = getString(R.string.status_lunas)
                binding.tvStatus.setTextColor(getColor(R.color.lunas_gray))
                binding.tvStatus.setBackgroundColor(getColor(R.color.lunas_gray_light))
            }
        }

        // Description
        if (debt.description.isNullOrBlank()) {
            binding.tvDescription.visibility = View.GONE
        } else {
            binding.tvDescription.visibility = View.VISIBLE
            binding.tvDescription.text = debt.description
        }

        // Dates
        binding.tvDateCreated.text = "Dibuat: ${DateUtil.formatDate(debt.dateCreated)}"
        if (debt.dueDate != null) {
            val label = DateUtil.dueDateLabel(debt.dueDate)
            binding.tvDueDate.text = "Jatuh tempo: ${DateUtil.formatDate(debt.dueDate)} ($label)"
        } else {
            binding.tvDueDate.text = "Tanpa jatuh tempo"
        }

        // Disable action buttons if lunas
        val isLunas = debt.status == DebtStatus.LUNAS
        binding.btnAddPayment.isEnabled = !isLunas
        binding.btnMarkPaid.isEnabled = !isLunas
        if (isLunas) {
            binding.btnAddPayment.alpha = 0.5f
            binding.btnMarkPaid.alpha = 0.5f
        } else {
            binding.btnAddPayment.alpha = 1f
            binding.btnMarkPaid.alpha = 1f
        }
    }
}
