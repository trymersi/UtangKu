package com.huskydev.hutangpiutang.ui.contact

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
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.databinding.ActivityContactDetailBinding
import com.huskydev.hutangpiutang.reminder.ReminderScheduler
import com.huskydev.hutangpiutang.ui.dashboard.DebtListAdapter
import com.huskydev.hutangpiutang.ui.detail.DebtDetailActivity
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.ViewModelFactory

class ContactDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailBinding
    private lateinit var viewModel: ContactViewModel
    private lateinit var adapter: DebtListAdapter
    private var currentContact: Contact? = null

    companion object {
        const val EXTRA_CONTACT_ID = "extra_contact_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as HutangPiutangApp
        viewModel = ViewModelProvider(this, ViewModelFactory {
            ContactViewModel(app.contactRepository, app.debtRepository, app.executor)
        })[ContactViewModel::class.java]

        val contactId = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        if (contactId == -1L) {
            finish()
            return
        }

        setupToolbar()
        setupRecyclerView()
        setupDeleteButton()
        observeData(contactId)
    }

    override fun onResume() {
        super.onResume()
        val contactId = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        if (contactId != -1L) {
            viewModel.loadContactDetails(contactId)
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        adapter = DebtListAdapter { debt ->
            val intent = Intent(this, DebtDetailActivity::class.java)
            intent.putExtra(DebtDetailActivity.EXTRA_DEBT_ID, debt.id)
            startActivity(intent)
        }
        binding.recyclerDebts.layoutManager = LinearLayoutManager(this)
        binding.recyclerDebts.adapter = adapter
    }

    private fun setupDeleteButton() {
        binding.btnDeleteContact.setOnClickListener {
            val contact = currentContact ?: return@setOnClickListener
            
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.confirm_delete_contact_title)
                .setMessage(R.string.confirm_delete_contact_message)
                .setPositiveButton(R.string.btn_yes_delete) { _, _ ->
                    viewModel.deleteContact(contact)
                }
                .setNegativeButton(R.string.cancel, null)
                .show()
        }
    }

    private fun observeData(contactId: Long) {
        viewModel.contactDetails.observe(this) { contact ->
            if (contact == null) return@observe
            currentContact = contact
            
            binding.tvContactName.text = contact.name
            binding.tvAvatarInitial.text = contact.name.first().uppercase()
            
            val bg = binding.avatarCircle.background
            if (bg is GradientDrawable) {
                bg.setColor(contact.avatarColor)
            }

            if (!contact.phone.isNullOrBlank()) {
                binding.tvPhone.visibility = View.VISIBLE
                binding.tvPhone.text = contact.phone
            } else {
                binding.tvPhone.visibility = View.GONE
            }

            // We use the same adapter as Dashboard, so we need to set the contact map manually
            adapter.setContacts(listOf(contact))
        }

        viewModel.contactNetBalance.observe(this) { balance ->
            val type = viewModel.contactNetType.value
            if (type == null) {
                binding.tvNetBalance.text = "Semua Lunas"
                binding.tvNetBalance.setTextColor(getColor(R.color.on_surface_secondary))
            } else {
                val formattedAmt = CurrencyFormatter.format(balance)
                if (type == DebtType.PIUTANG) {
                    binding.tvNetBalance.text = "Piutang: $formattedAmt"
                    binding.tvNetBalance.setTextColor(getColor(R.color.piutang_green))
                } else {
                    binding.tvNetBalance.text = "Hutang: $formattedAmt"
                    binding.tvNetBalance.setTextColor(getColor(R.color.hutang_red))
                }
            }
        }

        viewModel.getDebtsByContact(contactId).observe(this) { debts ->
            adapter.submitList(debts)
        }

        viewModel.deletedDebtIds.observe(this) { debtIds ->
            // Cancel all alarms associated with this contact's active debts
            for (id in debtIds) {
                ReminderScheduler.cancel(this, id)
            }
        }

        viewModel.deleteResult.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Kontak dihapus", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
