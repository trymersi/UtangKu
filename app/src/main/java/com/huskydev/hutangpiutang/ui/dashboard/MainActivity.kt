package com.huskydev.hutangpiutang.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.databinding.ActivityMainBinding
import com.huskydev.hutangpiutang.ui.about.AboutActivity
import com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtActivity
import com.huskydev.hutangpiutang.ui.contact.ContactListActivity
import com.huskydev.hutangpiutang.ui.detail.DebtDetailActivity
import com.huskydev.hutangpiutang.ui.settings.SettingsActivity
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DashboardViewModel
    private lateinit var adapter: DebtListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as HutangPiutangApp

        viewModel = ViewModelProvider(this, ViewModelFactory {
            DashboardViewModel(app.debtRepository)
        })[DashboardViewModel::class.java]

        setupToolbar()
        setupRecyclerView()
        setupChipFilter()
        setupFab()
        observeData()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)

        // Setup SearchView
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.setSearchQuery(newText ?: "")
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_contacts -> {
                startActivity(Intent(this, ContactListActivity::class.java))
                true
            }
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView() {
        adapter = DebtListAdapter { debt ->
            val intent = Intent(this, DebtDetailActivity::class.java)
            intent.putExtra(DebtDetailActivity.EXTRA_DEBT_ID, debt.id)
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupChipFilter() {
        binding.chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            if (checkedIds.isEmpty()) return@setOnCheckedStateChangeListener
            val chipId = checkedIds.first()
            val status = when (chipId) {
                R.id.chipPiutang -> null // Handled differently — we'll filter by type
                R.id.chipHutang -> null
                R.id.chipLunas -> DebtStatus.LUNAS
                else -> null // chipSemua
            }
            viewModel.setFilter(status)
        }
    }

    private fun setupFab() {
        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddEditDebtActivity::class.java))
        }
    }

    private fun observeData() {
        val app = application as HutangPiutangApp

        // Observe contacts for adapter's name resolution
        app.contactRepository.getAll().observe(this) { contacts ->
            adapter.setContacts(contacts)
        }

        // Observe filtered debts
        viewModel.displayedDebts.observe(this) { debts ->
            // Additional filter by type if chip is Piutang or Hutang
            val chipId = binding.chipGroup.checkedChipId
            val filtered = when (chipId) {
                R.id.chipPiutang -> debts.filter { it.type == com.huskydev.hutangpiutang.data.entity.DebtType.PIUTANG }
                R.id.chipHutang -> debts.filter { it.type == com.huskydev.hutangpiutang.data.entity.DebtType.HUTANG }
                else -> debts
            }

            adapter.submitList(filtered)

            // Toggle empty state
            binding.emptyState.visibility = if (filtered.isEmpty()) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (filtered.isEmpty()) View.GONE else View.VISIBLE
        }

        // Observe totals
        viewModel.totalPiutang.observe(this) { total ->
            binding.tvTotalPiutang.text = CurrencyFormatter.format(total ?: 0L)
        }

        viewModel.totalHutang.observe(this) { total ->
            binding.tvTotalHutang.text = CurrencyFormatter.format(total ?: 0L)
        }
    }
}
