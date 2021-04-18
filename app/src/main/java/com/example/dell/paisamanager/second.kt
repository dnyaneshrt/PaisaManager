package com.example.dell.paisamanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.add_expense.*
import kotlinx.android.synthetic.main.add_income.*


class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var fManager = fragmentManager
        var tx = fManager.beginTransaction()
        tx.add(R.id.frame,add_income())
        tx.commit()



    incomefrag.setOnClickListener({
            var fManager = fragmentManager
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frame,add_income())
            tx.commit()

        })

        expensefrag.setOnClickListener({
            var fManager = fragmentManager
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frame,add_expense())
            tx.commit()
        })




    }



  /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu2, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        when (item.itemId) {
            R.id.addcate -> return true
            else -> return super.onOptionsItemSelected(item)
        }

        when (item.itemId) {
            R.id.removecate -> return true
            else -> return super.onOptionsItemSelected(item)
        }
       }*/

}


