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

        binding.floatingButton.setOnClickListener {
            setaddNewOrderActive()
        }

//        binding.bottomNavigation.setOnItemSelectedListener {menuItem ->
//            when (menuItem.itemId) {
//                R.id.navigation_home -> {
//                    // Write your code here
//                    setHomeActive(menuItem)
//                    setaddNewOrderInActive()
//                }
//                R.id.navigation_order-> {
//                    // Write your code here
//                    setOrderActive(menuItem)
//                    setaddNewOrderInActive()
//                }
//                R.id.navigation_new_orders-> {
//                    // Write your code here
//                    setaddNewOrderActive()
//                }
//                R.id.navigation_notifications-> {
//                    // Write your code here
//                    setNotiActive(menuItem)
//                    setaddNewOrderInActive()
//                }
//                R.id.navigation_account-> {
//                    // Write your code here
//                    setProfileActive(menuItem)
//                    setaddNewOrderInActive()
//                }
//            }
//            return@setOnItemSelectedListener true
//        }

    }

    fun setHomeActive(item : MenuItem){
        item.setIcon(R.drawable.home_selected)
    }

    fun setHomeInActive(item : MenuItem){
        item.setIcon(R.drawable.home_unselected)
    }

    fun setOrderActive(item : MenuItem){
        item.setIcon(R.drawable.order_selected)
    }

    fun setOrderInActive(item : MenuItem){
        item.setIcon(R.drawable.order_unselected)
    }

    @SuppressLint("ResourceAsColor")
    fun setaddNewOrderActive(){
        binding.floatingButton.setImageResource(R.drawable.addnote_selected)
        binding.floatingButton.rippleColor = R.color.dark_button_color
    }

    @SuppressLint("ResourceAsColor")
    fun setaddNewOrderInActive(){
        binding.floatingButton.setImageResource(R.drawable.addnoteunselected)
        binding.floatingButton.rippleColor = R.color.dark_button_color
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