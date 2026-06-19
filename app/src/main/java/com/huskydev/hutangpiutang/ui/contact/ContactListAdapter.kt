package com.huskydev.hutangpiutang.ui.contact

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.util.CurrencyFormatter

class ContactListAdapter(
    private val onClick: (Long) -> Unit
) : ListAdapter<ContactViewModel.ContactWithNetBalance, ContactListAdapter.ContactViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarCircle: View = itemView.findViewById(R.id.avatarCircle)
        private val tvAvatarInitial: TextView = itemView.findViewById(R.id.tvAvatarInitial)
        private val tvContactName: TextView = itemView.findViewById(R.id.tvContactName)
        private val tvNetBalance: TextView = itemView.findViewById(R.id.tvNetBalance)

        fun bind(item: ContactViewModel.ContactWithNetBalance, onClick: (Long) -> Unit) {
            val contact = item.contact
            val ctx = itemView.context

            // Avatar
            tvAvatarInitial.text = contact.name.first().uppercase()
            val avatarBg = avatarCircle.background
            if (avatarBg is GradientDrawable) {
                avatarBg.setColor(contact.avatarColor)
            }

            // Name
            tvContactName.text = contact.name

            // Net balance
            if (item.type == null) {
                tvNetBalance.text = "Semua Lunas"
                tvNetBalance.setTextColor(ctx.getColor(R.color.on_surface_secondary))
            } else {
                val formattedAmt = CurrencyFormatter.format(item.netBalance)
                if (item.type == DebtType.PIUTANG) {
                    tvNetBalance.text = "Piutang: $formattedAmt"
                    tvNetBalance.setTextColor(ctx.getColor(R.color.piutang_green))
                } else {
                    tvNetBalance.text = "Hutang: $formattedAmt"
                    tvNetBalance.setTextColor(ctx.getColor(R.color.hutang_red))
                }
            }

            itemView.setOnClickListener { onClick(contact.id) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ContactViewModel.ContactWithNetBalance>() {
            override fun areItemsTheSame(
                oldItem: ContactViewModel.ContactWithNetBalance,
                newItem: ContactViewModel.ContactWithNetBalance
            ): Boolean = oldItem.contact.id == newItem.contact.id

            override fun areContentsTheSame(
                oldItem: ContactViewModel.ContactWithNetBalance,
                newItem: ContactViewModel.ContactWithNetBalance
            ): Boolean = oldItem == newItem
        }
    }
}
