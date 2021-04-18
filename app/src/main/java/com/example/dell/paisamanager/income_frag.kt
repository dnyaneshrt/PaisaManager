package com.example.dell.paisamanager


import android.app.Fragment
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class income_frag: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        var v=inflater!!.inflate(R.layout.income,container,false)
 var income_lview:ListView=view.findViewById(R.id.income_lview)


        return  v
    }
}