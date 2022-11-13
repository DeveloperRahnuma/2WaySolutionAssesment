package com.a2solution.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.a2solution.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //we are using toolbar in place of action bar ( for it you need to change them of app also )
        setSupportActionBar(binding.toolbar)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_order, R.id.navigation_new_orders,R.id.navigation_notifications,R.id.navigation_account,)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.centerButton.setOnClickListener {
//            setaddNewOrderActive()
        }

        binding.bottomNavigation.setOnItemSelectedListener {menuItem ->
//            setaddNewOrderInActive()
            return@setOnItemSelectedListener true
        }

    }



    @SuppressLint("ResourceAsColor")
    fun setaddNewOrderActive(){
        binding.centerButton.setCardBackgroundColor(R.color.dark_button_color)
        binding.centerButtonIcon.setImageResource(R.drawable.addnote_selected)
    }

    @SuppressLint("ResourceAsColor")
    fun setaddNewOrderInActive(){
        binding.centerButton.setCardBackgroundColor(R.color.light_button_color)
        binding.centerButtonIcon.setImageResource(R.drawable.addnoteunselected)
    }

    fun setNotiActive(item : MenuItem){
        item.setIcon(R.drawable.noti_selected)
    }

    fun setNotiInActive(item : MenuItem){
        item.setIcon(R.drawable.noti_unselected)
    }

    fun setProfileActive(item : MenuItem){
        item.setIcon(R.drawable.profile_selected)
    }

    fun setProfileInActive(item : MenuItem){
        item.setIcon(R.drawable.profile_unselected)
    }


    // adding optional menu which is on toolbar in a from of icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            //when search icon get clicked
            R.id.more_menu -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}