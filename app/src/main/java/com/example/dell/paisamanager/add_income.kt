package com.example.dell.paisamanager


import android.app.DatePickerDialog
import android.app.Fragment
import android.content.ContentValues
import android.content.Context

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.add_income.*
import java.util.*

class add_income:Fragment() {
    lateinit var dBase:SQLiteDatabase

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
      super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater!!.inflate(R.layout.add_income, container, false)

        var addincome:Button=view.findViewById(R.id.addincome)
var btndate:Button=view.findViewById(R.id.btndate)
        var dateet:EditText=view.findViewById(R.id.dateet)

dBase= activity.openOrCreateDatabase("project",Context.MODE_PRIVATE,null)


        dBase.execSQL("create table if not exists user(_id integer primary key autoincrement,category varchar(50),amount long,description varchar(100),dat date)")

addincome.setOnClickListener({
  if (spinner.selectedItem.toString().length > 0 && amountet.text.toString().length > 0 &&
          descet.text.toString().length > 0 && dateet.text.toString().length > 0) {
        var cv = ContentValues()
        cv.put("category", spinner.selectedItem.toString())
        cv.put("amount", amountet.text.toString().toLong())
        cv.put("description", descet.text.toString())
        cv.put("dat", dateet.text.toString())

        var status = dBase.insert("user", null, cv)

        if (status == -1.toLong()) {
            Toast.makeText(activity, "failed to insert", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, "data inserted successfully", Toast.LENGTH_LONG).show()

            amountet.setText("")
            descet.setText("")
            dateet.setText("")
        }
   }
  else
    {

        Snackbar.make(view, "please enter all details",
                Snackbar.LENGTH_LONG).setAction("Action", null).show();
       // Toast.makeText(activity,"fill all the blanks",Toast.LENGTH_LONG).show()
    }


})


        btndate.setOnClickListener({
            var c=Calendar.getInstance()
            var day=c.get(Calendar.DAY_OF_MONTH)
            var month=c.get(Calendar.MONTH)
            var year=c.get(Calendar.YEAR)


            var dpd=DatePickerDialog(activity,android.R.style.Theme_Holo_Dialog,
                    DatePickerDialog.OnDateSetListener
                    {view, year, month, dayOfMonth ->
                        dateet.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                    },year,month,day)
            dpd.show()
        })

    dateet.setOnClickListener({

            var c=Calendar.getInstance()
            var day=c.get(Calendar.DAY_OF_MONTH)
            var month=c.get(Calendar.MONTH)
            var year=c.get(Calendar.YEAR)


            var  dpd=DatePickerDialog(activity,android.R.style.Theme_Holo_Dialog,
                    DatePickerDialog.OnDateSetListener
                    {view, year, month, dayOfMonth ->
                        dateet.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                    },year,month,day)
            dpd.show()
        })
        return view
    }
}