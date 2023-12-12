package com.example.ordermanager02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ordermanager02.databinding.ActivityMainBinding
import com.example.ordermanager02.ui.ORDERS.detail_order.OrderViewModel
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    lateinit var navController: NavController
    lateinit var toolbar: Toolbar
    lateinit var viewModelOrderDetail: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModelOrderDetail = ViewModelProvider(this).get(OrderViewModel::class.java)

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)

        val navView: BottomNavigationView = binding.navView
        navController =
            Navigation.findNavController(APP_ACTIVITY, R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.main_orders, R.id.main_users, R.id.main_products
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
//Todo удалить функцию при добавлении viewPager
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.vpOrderDetail, fragment).commit()
    }
}