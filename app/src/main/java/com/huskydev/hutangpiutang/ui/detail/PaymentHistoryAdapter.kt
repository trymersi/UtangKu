package com.huskydev.hutangpiutang.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.entity.Payment
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil

class PaymentHistoryAdapter :
    ListAdapter<Payment, PaymentHistoryAdapter.PaymentViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvPaymentDate: TextView = itemView.findViewById(R.id.tvPaymentDate)
        private val tvPaymentNote: TextView = itemView.findViewById(R.id.tvPaymentNote)
        private val tvPaymentAmount: TextView = itemView.findViewById(R.id.tvPaymentAmount)

        fun bind(payment: Payment) {
            tvPaymentDate.text = DateUtil.formatDate(payment.paymentDate)
            tvPaymentAmount.text = "- ${CurrencyFormatter.format(payment.amount)}"

            if (payment.note.isNullOrBlank()) {
                tvPaymentNote.visibility = View.GONE
            } else {
                tvPaymentNote.visibility = View.VISIBLE
                tvPaymentNote.text = payment.note
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Payment>() {
            override fun areItemsTheSame(oldItem: Payment, newItem: Payment) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Payment, newItem: Payment) =
                oldItem == newItem
        }
    }
}
