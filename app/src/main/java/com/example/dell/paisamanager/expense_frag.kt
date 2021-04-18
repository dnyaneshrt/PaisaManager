package com.example.dell.paisamanager


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class expense_frag:Fragment() {


        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View
        {
            super.onCreateView(inflater, container, savedInstanceState)

            var v=inflater!!.inflate(R.layout.expense,container,false)

            return  v
        }
}