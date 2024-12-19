package com.wsa.rideapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    //Initialize
    lateinit var pick: EditText
    lateinit var dest: EditText
    lateinit var timePicker: Button
    lateinit var datePick: Button
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views in activity
        pick = findViewById(R.id.pick_et)
        dest = findViewById(R.id.dest_et)
        submit = findViewById(R.id.submit_btn)
        timePicker = findViewById(R.id.time_btn)
        datePick = findViewById(R.id.date_btn)

        // Set up the date & time picker
        datePick.setOnClickListener(this)
        timePicker.setOnClickListener(this)

        submit.setOnClickListener(this)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(value: View?) {
        //time & date pickers

        val timeline = Calendar.getInstance()
        val hour = timeline.get(Calendar.HOUR)
        val mins = timeline.get(Calendar.MINUTE)

        val year = timeline.get(Calendar.YEAR)
        val month = timeline.get(Calendar.MONTH)
        val day = timeline.get(Calendar.DAY_OF_MONTH)
        if(value!= null)
        {
            when(value?.id)
            {
                R.id.time_btn -> {TimePickerDialog(this,this, hour,mins,false).show()}
                R.id.date_btn -> {DatePickerDialog(this,this,year,month,day).show()}
                R.id.submit_btn -> {
                    if(pick.text.toString().isEmpty()|| dest.text.toString().isEmpty())
                    {
                       Toast.makeText(this,"enter the details",Toast.LENGTH_LONG).show()

                    }
                    else if(datePick.text.toString() == "select the date")
                    {
                        Toast.makeText(this,"select the date",Toast.LENGTH_LONG).show()
                    }
                    else if(timePicker.text.toString() == "select the time")
                    {
                        Toast.makeText(this,"select the time",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        val sub_intent = Intent(this,DetailsActivity::class.java)
                        sub_intent.putExtra("pickup",pick.text.toString())
                        sub_intent.putExtra("Dest",dest.text.toString())
                        sub_intent.putExtra("Date",datePick.text.toString())
                        sub_intent.putExtra("Time",timePicker.text.toString())
                        startActivity(sub_intent)

                    }

                }

            }
        }
    }

    override fun onTimeSet(p0: TimePicker?, hr: Int , min: Int) {
        val ntime = "$hr: $min"
        timePicker.text = ntime
    }
    override fun onDateSet(p0: DatePicker?, yr: Int, mon: Int, day: Int) {
        val ndate = "$day-${mon+1}-$yr"
        datePick.text = ndate

    }
}