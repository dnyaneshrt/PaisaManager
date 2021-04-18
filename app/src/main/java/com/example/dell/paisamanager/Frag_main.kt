package com.example.dell.paisamanager

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SimpleCursorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.mainfrag.*

class Frag_main:Fragment() {
lateinit var all:Button
    lateinit var income:Button
    lateinit var expense:Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.mainfrag,container,false)

var income:Button=view.findViewById(R.id.income)
        var all:Button=view.findViewById(R.id.all)

        var expense:Button=view.findViewById(R.id.expense)

        income.setOnClickListener({
            lateinit var dBase: SQLiteDatabase
            dBase= activity!!.openOrCreateDatabase("project", Context.MODE_PRIVATE,null)


            dBase.execSQL("create table if not exists user(_id integer primary key autoincrement,category varchar(50),amount long,description varchar(100),dat date)")
            var c: Cursor = dBase.query("user", null, "category=?", arrayOf("income"),
                    null, null, null)

            /*   var list = mutableListOf<String>()

               while (c.moveToNext()) {
                  list.add("${c.getString(0)} \t\t\t ${c.getString(3)} \t\t\t ${c.getLong(1)}   \t\t\t ${c.getString(2)}")

                }
                    var adapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,list)
                   lview.adapter=adapter
                */

            var from:Array<String> = arrayOf("category",
                    "dat","amount","description")
            var to: IntArray = intArrayOf(R.id.t1, R.id.t2,R.id.t3,R.id.t4)
            var adapter = SimpleCursorAdapter(activity,
                    R.layout.mystyle,c,from,to,0)
            lview.adapter = adapter

        })

        all.setOnClickListener({
            lateinit var dBase: SQLiteDatabase
            dBase= activity!!.openOrCreateDatabase("project", Context.MODE_PRIVATE,null)


            dBase.execSQL("create table if not exists user(_id integer primary key autoincrement,category varchar(50),amount long,description varchar(100),dat date)")
            var c: Cursor = dBase.query("user", null, null, null,
                    null, null, null)

            /*  var list = mutableListOf<String>()

              while (c.moveToNext()) {
                  list.add("${c.getString(0)} \t\t\t ${c.getString(3)} \t\t\t ${c.getLong(1)}   \t\t\t ${c.getString(2)}")

              }
              var adapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,list)
              lview.adapter=adapter*/

            var from: Array<String> = arrayOf("category",
                    "dat", "amount", "description")
            var to: IntArray = intArrayOf(R.id.t21, R.id.t22, R.id.t23, R.id.t24)
            var adapter = SimpleCursorAdapter(activity,
                    R.layout.mystyle2, c, from, to, 0)
            lview.adapter = adapter



        })
        expense.setOnClickListener({
            lateinit var dBase: SQLiteDatabase
            dBase= activity!!.openOrCreateDatabase("project", Context.MODE_PRIVATE,null)


            dBase.execSQL("create table if not exists user(_id integer primary key autoincrement,category varchar(50),amount long,description varchar(100),dat date)")
            var c: Cursor = dBase.query("user", null, "category=?", arrayOf("expense"),
                    null, null, null)

            /*  var list = mutableListOf<String>()

              while (c.moveToNext()) {
                  list.add("${c.getString(0)} \t\t\t ${c.getString(3)} \t\t\t ${c.getLong(1)}   \t\t\t ${c.getString(2)}")

              }
              var adapter= ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,list)
              lview.adapter=adapter*/

            var from:Array<String> = arrayOf("category",
                    "dat","amount","description")
            var to: IntArray = intArrayOf(R.id.t11, R.id.t12,R.id.t13,R.id.t14)
            var adapter = SimpleCursorAdapter(activity,
                    R.layout.mystyle1,c,from,to,0)
            lview.adapter = adapter
        })
        return view
    }
}