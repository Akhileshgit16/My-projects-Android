package com.wsa.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomAlertFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //create builder inter
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.custom_signinlayout)
        return builder.create()
    }
}