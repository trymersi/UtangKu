package com.huskydev.hutangpiutang.ui.dashboard

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil

/**
 * Adapter untuk daftar debt di Dashboard.
 * Butuh Map<Long, Contact> untuk resolve nama kontak dari contactId.
 */
class DebtListAdapter(
    private val onClick: (Debt) -> Unit
) : ListAdapter<Debt, DebtListAdapter.DebtViewHolder>(DIFF_CALLBACK) {

    /** Map contactId → Contact, di-update dari luar via setContacts() */
    private var contactMap: Map<Long, Contact> = emptyMap()

    fun setContacts(contacts: List<Contact>) {
        contactMap = contacts.associateBy { it.id }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_debt, parent, false)
        return DebtViewHolder(view)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        val debt = getItem(position)
        val contact = contactMap[debt.contactId]
        holder.bind(debt, contact, onClick)
    }

    class DebtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarCircle: View = itemView.findViewById(R.id.avatarCircle)
        private val tvAvatarInitial: TextView = itemView.findViewById(R.id.tvAvatarInitial)
        private val tvContactName: TextView = itemView.findViewById(R.id.tvContactName)
        private val tvType: TextView = itemView.findViewById(R.id.tvType)
        private val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        private val progressBar: LinearProgressIndicator = itemView.findViewById(R.id.progressBar)
        private val tvDueDate: TextView = itemView.findViewById(R.id.tvDueDate)
        private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

        fun bind(debt: Debt, contact: Contact?, onClick: (Debt) -> Unit) {
            val ctx = itemView.context
            val name = contact?.name ?: "?"

            // Avatar
            tvAvatarInitial.text = name.first().uppercase()
            val avatarBg = avatarCircle.background
            if (avatarBg is GradientDrawable) {
                avatarBg.setColor(contact?.avatarColor ?: 0xFF9CA3AF.toInt())
            }

            // Contact name
            tvContactName.text = name

            // Type badge
            if (debt.type == DebtType.PIUTANG) {
                tvType.text = ctx.getString(R.string.piutang_label)
                tvType.setTextColor(ctx.getColor(R.color.piutang_green))
                tvType.setBackgroundColor(ctx.getColor(R.color.piutang_green_light))
            } else {
                tvType.text = ctx.getString(R.string.hutang_label)
                tvType.setTextColor(ctx.getColor(R.color.hutang_red))
                tvType.setBackgroundColor(ctx.getColor(R.color.hutang_red_light))
            }

            // Amount — show remaining if partially paid, otherwise original
            val displayAmount = if (debt.status == DebtStatus.SEBAGIAN) debt.remainingAmount else debt.originalAmount
            tvAmount.text = CurrencyFormatter.format(displayAmount)
            tvAmount.setTextColor(
                if (debt.type == DebtType.PIUTANG) ctx.getColor(R.color.piutang_green)
                else ctx.getColor(R.color.hutang_red)
            )

            // Description
            if (debt.description.isNullOrBlank()) {
                tvDescription.visibility = View.GONE
            } else {
                tvDescription.visibility = View.VISIBLE
                tvDescription.text = debt.description
            }

            // Progress bar
            val paid = debt.originalAmount - debt.remainingAmount
            val progressPercent = if (debt.originalAmount > 0) {
                (paid * 100 / debt.originalAmount).toInt()
            } else 0
            progressBar.progress = progressPercent

            // Due date
            if (debt.dueDate != null) {
                val label = DateUtil.dueDateLabel(debt.dueDate)
                val dateStr = DateUtil.formatDate(debt.dueDate)
                tvDueDate.text = "$label · $dateStr"

                val daysLeft = DateUtil.daysFromNow(debt.dueDate)
                tvDueDate.setTextColor(
                    when {
                        debt.status == DebtStatus.LUNAS -> ctx.getColor(R.color.lunas_gray)
                        daysLeft < 0 -> ctx.getColor(R.color.hutang_red)
                        daysLeft <= 3 -> ctx.getColor(R.color.due_soon_orange)
                        else -> ctx.getColor(R.color.on_surface_secondary)
                    }
                )
            } else {
                tvDueDate.text = "Tanpa jatuh tempo"
                tvDueDate.setTextColor(ctx.getColor(R.color.on_surface_secondary))
            }

            // Status badge
            when (debt.status) {
                DebtStatus.BELUM_LUNAS -> {
                    tvStatus.text = ctx.getString(R.string.status_belum_lunas)
                    tvStatus.setTextColor(ctx.getColor(R.color.due_soon_orange))
                    tvStatus.setBackgroundColor(ctx.getColor(R.color.due_soon_orange_light))
                }
                DebtStatus.SEBAGIAN -> {
                    tvStatus.text = ctx.getString(R.string.status_sebagian)
                    tvStatus.setTextColor(ctx.getColor(R.color.primary))
                    tvStatus.setBackgroundColor(ctx.getColor(R.color.surface_variant))
                }
                DebtStatus.LUNAS -> {
                    tvStatus.text = ctx.getString(R.string.status_lunas)
                    tvStatus.setTextColor(ctx.getColor(R.color.lunas_gray))
                    tvStatus.setBackgroundColor(ctx.getColor(R.color.lunas_gray_light))
                }
            }

            itemView.setOnClickListener { onClick(debt) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Debt>() {
            override fun areItemsTheSame(oldItem: Debt, newItem: Debt): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Debt, newItem: Debt): Boolean =
                oldItem == newItem
        }
    }
}
