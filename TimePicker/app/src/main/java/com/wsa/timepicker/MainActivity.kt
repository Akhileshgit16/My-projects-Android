package com.wsa.timepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    lateinit var timePicker: Button
    lateinit var datePick: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        timePicker = findViewById(R.id.timepick_btn)
        datePick = findViewById(R.id.date_btn)
        timePicker.setOnClickListener(this)
        datePick.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onClick(p0: View?) {
        val cal = Calendar.getInstance()
        val hr: Int = cal.get(Calendar.HOUR)
        val min: Int = cal.get(Calendar.MINUTE)
        val year: Int = cal.get(Calendar.YEAR)
        val mon: Int = cal.get(Calendar.MONTH)
        val day_of_month = cal.get(Calendar.DAY_OF_MONTH)
        if (p0 != null) {
            when (p0.id) {
                R.id.timepick_btn -> TimePickerDialog(this, this, hr, min, false).show()
                R.id.date_btn -> DatePickerDialog(this, this, year, mon, day_of_month).show()
            }
        }
    }
    override fun onTimeSet(p0: TimePicker?, hr: Int, min: Int) {
        val newtime = "$hr:$min"
        timePicker.text = newtime
    }
    override fun onDateSet(p0: DatePicker?, Year: Int, Month: Int, Day: Int) {
        val newdate = "$Day/ ${Month+1}/ $Year"
        datePick.text = newdate
    }
}
