package com.example.dell.paisamanager

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle

import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_income.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.mainfrag.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var fManager=supportFragmentManager
    var tx=fManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

      var fManager=supportFragmentManager
        var tx=fManager.beginTransaction()
        tx.add(R.id.fragment1,Frag_main())
        tx.commit()




        fab.setOnClickListener { view ->
            var intent= Intent(this@MainActivity,second::class.java)
            startActivity(intent)



        }



        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings ->
            {
                var fManager=supportFragmentManager
                var tx=fManager.beginTransaction()
            tx.replace(R.id.fragment1,Settings_frag())
                tx.addToBackStack("Frag_main")
                    tx.commit()
            }
          //      return true
       //     else -> return super.onOptionsItemSelected(item)
        }
       /* when (item.itemId) {
            R.id.addcate -> return true
            else -> return super.onOptionsItemSelected(item)
        }

        when (item.itemId) {
            R.id.removecate -> return true
            else -> return super.onOptionsItemSelected(item)
        }*/
        when (item.itemId) {
            R.id.rate -> return true
            else -> return super.onOptionsItemSelected(item)
        }}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.settings -> {

                // Handle the camera action

                var fManager=supportFragmentManager
                var tx=fManager.beginTransaction()
                tx.replace(R.id.fragment1,Settings_frag())
                tx.addToBackStack("Frag_main")
                tx.commit()
            }
            R.id.search -> {

            }
            R.id.chart -> {

            }
           R.id.delete ->{

           }
            R.id.backup -> {

            }
            R.id.share -> {

            }
            R.id.contact -> {

            }
            R.id.rate -> {

            }


            R.id.tc -> {
                // Handle the camera action
            }



        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
