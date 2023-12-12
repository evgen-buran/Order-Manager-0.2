package com.example.ordermanager02.ui.PRODUCTS.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.databinding.FragmentProductMainBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.example.ordermanager02.utils.showToast

class ProductMainFragment : Fragment() {
    lateinit var binding: FragmentProductMainBinding
    private lateinit var viewModel: ProductMainViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductMainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductMainBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.rvMainProduct
        adapter = ProductMainAdapter()
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(ProductMainViewModel::class.java)
        viewModel.getAllProducts()
        viewModel.liveData.observe(this) { adapter.setList(it) }
        binding.btnFabProduct.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_productMainFragment_to_addProductFragment)
        }

    }

    companion object {
        fun click(product: AppProduct) {
            showToast("Clicl Item Product")
        }
    }
}
