package com.example.ordermanager02.ui.ORDERS.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.JoinOrder
import com.example.ordermanager02.databinding.FragmentMainOrderBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.example.ordermanager02.utils.showToast

class OrderMainFragment : Fragment() {

    private var _binding: FragmentMainOrderBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: OrderMainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: OrderMainAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainOrderBinding.inflate(inflater, container, false)
        adapter = OrderMainAdapter()
        val toolbar: ActionBar? = APP_ACTIVITY.supportActionBar
        toolbar?.title = getString(R.string.title_main)

        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        showToast("pressed item menu")
        // TODO: обработать нажатие пункта меню
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(OrderMainViewModel::class.java)
        viewModel.initBD()
        viewModel.getAllOrders()
        viewModel.liveData.observe(this, Observer { adapter.setList(it) })
        binding.btnFabMain.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_navigation_orders_to_addOrderFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun clickItemList(order: JoinOrder) {
            val bundle = Bundle()
            bundle.putSerializable("joinOrder", order)
            APP_ACTIVITY.navController.navigate(
                R.id.action_main_orders_to_orderFragment, bundle
            )

        }
    }
}