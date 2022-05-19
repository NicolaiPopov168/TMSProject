package com.example.tmsproject.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.tmsproject.databinding.DeleteDialogBinding
import com.example.tmsproject.databinding.NewListDialogBinding

object DeleteDialog {

    fun showDialog(context: Context, listener: Listener) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = DeleteDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            bDelete.setOnClickListener {
                listener.onCLick()
                dialog?.dismiss()
            }
            bCancel.setOnClickListener {
                dialog?.dismiss()
            }
        }
        dialog = builder.create()
        dialog.window?.setBackgroundDrawable(null)
        dialog.show()
    }

    interface Listener {
        fun onCLick()
    }
}