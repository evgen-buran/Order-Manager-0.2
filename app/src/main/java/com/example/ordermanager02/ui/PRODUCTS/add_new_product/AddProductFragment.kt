package com.example.ordermanager02.ui.PRODUCTS.add_new_product

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.databinding.FragmentAddProductBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.example.ordermanager02.utils.showToast

class AddProductFragment : Fragment() {

    lateinit var binding: FragmentAddProductBinding
    lateinit var viewModel: AddProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(this).get(AddProductViewModel::class.java)
        addProduct()

    }
    fun addProduct() {
        binding.btnAddProduct.setOnClickListener{
            val nameProduct = binding.etNameProduct.text.toString()
            val descriptionProduct = binding.etDecriptionProduct.text.toString()
            val priceProduct = binding.etPriceProduct.text.toString()
            if(nameProduct.isEmpty()) showToast(getString(R.string.enter_name_of_product))
            else {
                viewModel.insertProduct(AppProduct(nameProduct = nameProduct, descriptionProduct = descriptionProduct, priceProduct = priceProduct.toFloat()))
                APP_ACTIVITY.navController.navigate(R.id.action_addProductFragment_to_productMainFragment)
                showToast("Added new product")
            }

        }
    }

}