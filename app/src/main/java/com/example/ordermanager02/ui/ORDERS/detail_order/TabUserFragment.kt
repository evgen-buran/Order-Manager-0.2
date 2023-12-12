package com.example.ordermanager02.ui.ORDERS.detail_order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordermanager02.databinding.FragmentTabUserBinding
import com.example.ordermanager02.utils.APP_ACTIVITY

class TabUserFragment : Fragment() {
    lateinit var viewModel: OrderViewModel
    lateinit var binding: FragmentTabUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTabUserBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
//todo получить viewModel из OrderFragment, а не инициализировать новую
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = APP_ACTIVITY.viewModelOrderDetail
        viewModel.orderLiveData.observe(viewLifecycleOwner) {
            binding.tvOrderFirstNameDetail.text = it.nameUser
            binding.tvOrderSecondNameDetail.text = it.secondNameUser
        }
    }

    companion object {
        fun newInstance() = TabUserFragment()
    }
}