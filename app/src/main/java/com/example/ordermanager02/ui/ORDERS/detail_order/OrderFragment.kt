package com.example.ordermanager02.ui.ORDERS.detail_order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ordermanager02.R
import com.example.ordermanager02.database.JoinOrder
import com.example.ordermanager02.databinding.FragmentDetailOrderBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : Fragment() {
    val TAG = "myLogs"
    private var _binding: FragmentDetailOrderBinding? = null
    val binding: FragmentDetailOrderBinding
        get() = _binding!!

    private lateinit var viewModel: OrderViewModel
    private lateinit var currentOrder: JoinOrder

    private val listTabOrder =
        listOf(TabOrderFragment.newInstance(), TabUserFragment.newInstance())
    private val listTitleTab = listOf("Order", "User")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailOrderBinding.inflate(inflater, container, false)
        val toolbar = APP_ACTIVITY.supportActionBar
        toolbar?.title = getString(R.string.add_new_order)
        toolbar?.setDisplayShowTitleEnabled(false)
        toolbar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
        currentOrder = arguments?.getSerializable("joinOrder") as JoinOrder

        val adapter = OrderAdapter(APP_ACTIVITY, listTabOrder)
        binding.vpOrderDetail.adapter = adapter
        return binding.root
    }

    override fun onStart() {
        super.onStart()
//        APP_ACTIVITY.replaceFragment(TabOrderFragment.newInstance())


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = APP_ACTIVITY.viewModelOrderDetail
        viewModel.orderLiveData.value = currentOrder
        TabLayoutMediator(binding.tabLayout, binding.vpOrderDetail) { tab, position ->
            tab.text = listTitleTab.get(position)
        }.attach()
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                when (tab?.position) {
//                    0 -> {
//                        APP_ACTIVITY.replaceFragment(TabOrderFragment.newInstance())
//                    }
//
//                    1 -> {
//                        APP_ACTIVITY.replaceFragment((TabUserFragment.newInstance()))
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                APP_ACTIVITY.navController.navigate(R.id.action_detailUserFragment_to_userMainFragment2)
//                APP_ACTIVITY.navController.navigate(R.id.action_orderFragment_to_navigation_orders)

            }

        }
        return super.onOptionsItemSelected(item)
    }
}