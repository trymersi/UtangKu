package com.huskydev.hutangpiutang.ui.contact

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.databinding.ActivityContactListBinding
import com.huskydev.hutangpiutang.util.ViewModelFactory

class ContactListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactListBinding
    private lateinit var viewModel: ContactViewModel
    private lateinit var adapter: ContactListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as HutangPiutangApp
        viewModel = ViewModelProvider(this, ViewModelFactory {
            ContactViewModel(app.contactRepository, app.debtRepository, app.executor)
        })[ContactViewModel::class.java]

        setupToolbar()
        setupRecyclerView()
        observeData()
    }

    override fun onResume() {
        super.onResume()
        // Refresh every time screen becomes visible
        viewModel.loadContactsWithBalances()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupRecyclerView() {
        adapter = ContactListAdapter { contactId ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra(ContactDetailActivity.EXTRA_CONTACT_ID, contactId)
            startActivity(intent)
        }
        binding.recyclerContacts.layoutManager = LinearLayoutManager(this)
        binding.recyclerContacts.adapter = adapter
    }

    private fun observeData() {
        viewModel.contactWithNetBalance.observe(this) { items ->
            adapter.submitList(items)
            binding.emptyState.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
            binding.recyclerContacts.visibility = if (items.isEmpty()) View.GONE else View.VISIBLE
        }
    }
}
