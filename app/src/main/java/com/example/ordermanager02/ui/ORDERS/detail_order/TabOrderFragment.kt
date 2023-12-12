package com.example.ordermanager02.ui.ORDERS.detail_order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordermanager02.R
import com.example.ordermanager02.databinding.FragmentTabOrderBinding
import com.example.ordermanager02.utils.APP_ACTIVITY

class TabOrderFragment : Fragment() {
    lateinit var viewModel: OrderViewModel
    lateinit var binding: FragmentTabOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTabOrderBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = APP_ACTIVITY.viewModelOrderDetail
        viewModel.orderLiveData.observe(viewLifecycleOwner) {
            binding.tvOrderIdDetail.text = it.id.toString()
            binding.tvOrderDescriptionDetail.text = it.description.toString()
        }

    }


    companion object {
        fun newInstance() = TabOrderFragment()
    }
}