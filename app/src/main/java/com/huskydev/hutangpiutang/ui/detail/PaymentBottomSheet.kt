package com.huskydev.hutangpiutang.ui.detail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.databinding.FragmentPaymentBottomSheetBinding
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil

class PaymentBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentPaymentBottomSheetBinding? = null
    private val binding get() = _binding!!

    private var remainingAmount: Long = 0
    private var paymentDateMillis: Long = System.currentTimeMillis()
    private var isFormatting = false
    private var onPaymentSubmit: ((amount: Long, date: Long, note: String?) -> Unit)? = null

    companion object {
        private const val ARG_REMAINING = "arg_remaining"

        fun newInstance(remainingAmount: Long): PaymentBottomSheet {
            return PaymentBottomSheet().apply {
                arguments = Bundle().apply {
                    putLong(ARG_REMAINING, remainingAmount)
                }
            }
        }
    }

    fun setOnPaymentSubmitListener(listener: (amount: Long, date: Long, note: String?) -> Unit) {
        onPaymentSubmit = listener
    }

    override fun getTheme(): Int = R.style.Theme_UtangKu_BottomSheet

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPaymentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        remainingAmount = arguments?.getLong(ARG_REMAINING) ?: 0

        binding.tvRemainingInfo.text = "Sisa: ${CurrencyFormatter.format(remainingAmount)}"
        binding.etPaymentDate.setText(DateUtil.formatDate(paymentDateMillis))

        // Amount formatter
        binding.etPaymentAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (isFormatting) return
                isFormatting = true
                val formatted = CurrencyFormatter.formatRaw(s.toString())
                binding.etPaymentAmount.setText(formatted)
                binding.etPaymentAmount.setSelection(formatted.length)
                isFormatting = false
            }
        })

        // Date picker
        binding.etPaymentDate.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Tanggal Pembayaran")
                .setSelection(paymentDateMillis)
                .build()
            picker.addOnPositiveButtonClickListener { millis ->
                paymentDateMillis = millis
                binding.etPaymentDate.setText(DateUtil.formatDate(millis))
            }
            picker.show(parentFragmentManager, "payment_date")
        }

        // Save
        binding.btnSavePayment.setOnClickListener {
            val amount = CurrencyFormatter.parse(binding.etPaymentAmount.text.toString())

            if (amount <= 0) {
                binding.tilPaymentAmount.error = getString(R.string.error_amount_zero)
                return@setOnClickListener
            }

            if (amount > remainingAmount) {
                binding.tilPaymentAmount.error =
                    getString(R.string.error_payment_exceeds, CurrencyFormatter.format(remainingAmount))
                return@setOnClickListener
            }

            binding.tilPaymentAmount.error = null
            val note = binding.etPaymentNote.text.toString().trim().ifEmpty { null }
            onPaymentSubmit?.invoke(amount, paymentDateMillis, note)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
