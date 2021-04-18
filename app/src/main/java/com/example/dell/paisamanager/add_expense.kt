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
import kotlinx.android.synthetic.main.add_expense.*


import java.util.*


class add_expense : Fragment() {
    lateinit var dBase: SQLiteDatabase

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater!!.inflate(R.layout.add_expense, container, false)

        var addexpense: Button = view.findViewById(R.id.addexpense)
        var btndate1: Button = view.findViewById(R.id.btndate1)
        var dateet1: EditText = view.findViewById(R.id.dateet1)

        dBase = activity.openOrCreateDatabase("project", Context.MODE_PRIVATE, null)


        dBase.execSQL("create table if not exists user1(_id integer primary key autoincrement,category varchar(50),amount long,description varchar(100),dat date)")

        addexpense.setOnClickListener({
            if (spinner1.selectedItem.toString().length > 0 && amountet1.text.toString().length > 0 &&
                    descet1.text.toString().length > 0 && dateet1.text.toString().length > 0) {
                var cv = ContentValues()
                cv.put("category", spinner1.selectedItem.toString())
                cv.put("amount", amountet1.text.toString().toLong())
                cv.put("description", descet1.text.toString())
                cv.put("dat", dateet1.text.toString())

                var status = dBase.insert("user", null, cv)

                if (status == -1.toLong()) {
                    Toast.makeText(activity, "failed to insert", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "data inserted successfully", Toast.LENGTH_LONG).show()

                    amountet1.setText("")
                    descet1.setText("")
                    dateet1.setText("")
                }
            } else {

                Snackbar.make(view, "please enter all details",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show();
                // Toast.makeText(activity,"fill all the blanks",Toast.LENGTH_LONG).show()
            }
        })

        btndate1.setOnClickListener({
            var c = Calendar.getInstance()
            var day = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)


            var dpd = DatePickerDialog(activity, android.R.style.Theme_Holo_Dialog,
                    DatePickerDialog.OnDateSetListener
                    { view, year, month, dayOfMonth ->
                        dateet1.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                    }, year, month, day)
            dpd.show()

        })

        dateet1.setOnClickListener({
            var c = Calendar.getInstance()
            var day = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)


            var dpd = DatePickerDialog(activity, android.R.style.Theme_Holo_Dialog,
                    DatePickerDialog.OnDateSetListener
                    { view, year, month, dayOfMonth ->
                        dateet1.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                    }, year, month, day)
            dpd.show()
        })

        return view


    }

}