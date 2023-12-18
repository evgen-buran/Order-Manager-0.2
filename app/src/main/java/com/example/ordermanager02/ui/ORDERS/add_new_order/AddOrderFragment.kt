package com.example.ordermanager02.ui.ORDERS.add_new_order

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppOrder
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.databinding.FragmentAddOrderBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.example.ordermanager02.utils.showToast
import java.text.SimpleDateFormat
import java.util.Date

class AddOrderFragment : Fragment() {
    val TAG = "myLog"
    private lateinit var viewModel: AddOrderViewModel
    private var _binding: FragmentAddOrderBinding? = null
    val binding: FragmentAddOrderBinding get() = _binding!!

    private var listUsers: List<AppUser> = emptyList()
    private var listProduct: List<AppProduct> = emptyList()
    private var currentUser: AppUser? = null
    private var currentProduct: AppProduct? = null

    private var price: Float = 0f
    private var sum: Float = 0f
    private var count: Int = 0

    private var autoCompleteUserAdapter: ListUserAdapter =
        ListUserAdapter(APP_ACTIVITY, listUsers)
    private var autoCompleteProductAdapter: ListProductAdapter =
        ListProductAdapter(APP_ACTIVITY, listProduct)
    lateinit var tvUserAutoComplete: AutoCompleteTextView
    lateinit var tvProductAutoComplete: AutoCompleteTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddOrderBinding.inflate(layoutInflater, container, false)


        val toolbar = APP_ACTIVITY.supportActionBar
        toolbar?.title = getString(R.string.add_new_order)
        toolbar?.setDisplayShowTitleEnabled(false)
        toolbar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this).get(AddOrderViewModel::class.java)

        viewModel.liveData.observe(this) {
            if (it != null) {
                listUsers = it
                autoCompleteUserAdapter = ListUserAdapter(APP_ACTIVITY, listUsers)
                tvUserAutoComplete.setAdapter(autoCompleteUserAdapter)

                Log.d(TAG, " OBSERVE!!: ${listUsers.size} - ${tvUserAutoComplete.adapter.count}")
            } else {

            }
//            it?.apply {
//                listUsers = it
//                autoCompleteAdapter = ListUserAdapter(APP_ACTIVITY, listUsers)
//                tvAutoComplete.setAdapter(autoCompleteAdapter)
//            }
        }
        viewModel.liveDataProduct.observe(this) {
            if (it != null) {
                listProduct = it
                autoCompleteProductAdapter = ListProductAdapter(APP_ACTIVITY, listProduct)
                //почему не adapter = autoCompleteProductAdapter
                tvProductAutoComplete.setAdapter(autoCompleteProductAdapter)

            }
        }
        //вызвать изменения в списке
        viewModel.getAllUsers()
        viewModel.getAllProduct()
        Log.d(TAG, "onStart: ${listUsers.size} and ${listProduct.size}")
        tvUserAutoComplete = binding.tvNameUserAuto
        tvProductAutoComplete = binding.tvProductNameAutoOrder
        val tvDate = SimpleDateFormat("dd.MM.yyyy").format(Date())
        binding.tvDateAddOrder.text = tvDate

        // получить юзера по id. обработать клик во Всплывающем списке
        // и узнать его позицию.
        // по позиции(или айди получить объект и передать его в инсертОрдер
        tvUserAutoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val id = autoCompleteUserAdapter.getItemId(position)
                currentUser = autoCompleteUserAdapter.getUserById(id)
                Log.d(
                    TAG, "UserID: ${currentUser?.user_id}, $id" +
                            "Name: ${currentUser?.nameUser}, " +
                            "#Item position: $position"
                )
            }

        tvProductAutoComplete.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val id = autoCompleteProductAdapter.getItemId(position)
                currentProduct = autoCompleteProductAdapter.getProductById(id)

                price = currentProduct?.priceProduct ?: 0.0.toFloat()
                count = binding.etCountProductAddOrder?.text?.toString()?.toIntOrNull() ?: 0
                sum = (price * count)

                binding.tvPriceProductAddOrder.text = price.toString()
                binding.tvSumAddOrder.text = sum.toString()
            }
        //проверка на отсутствие пользователя. если после ввода всплывающий список пуст
        //то дать возможность добавить пользователя
        tvUserAutoComplete.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (autoCompleteUserAdapter.isEmpty) {
                    binding.tvGoNewUser.visibility = View.VISIBLE
                }
                if (s.toString()?.length == 0) binding.tvGoNewUser.visibility = View.INVISIBLE
            }
        })
        tvProductAutoComplete.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (autoCompleteProductAdapter.isEmpty) {
                    binding.tvGoNewProduct.visibility = View.VISIBLE
                }
                if (p0.toString()?.length == 0) binding.tvGoNewProduct.visibility = View.INVISIBLE

            }


        })
        binding.etCountProductAddOrder.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                count = binding.etCountProductAddOrder?.text?.toString()?.toIntOrNull() ?: 0
                sum = (price * count)
                binding.tvSumAddOrder.text = sum.toString()

            }
        })


        binding.tvGoNewUser.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("newName", binding.tvNameUserAuto.text.toString())
//            bundle.putInt("destinationOrder", R.id.action_addUserFragment_to_addOrderFragment)
            APP_ACTIVITY.navController.navigate(
                R.id.action_addOrderFragment_to_addUserFragment,
                bundle
            )
        }
        binding.tvGoNewProduct.setOnClickListener(){
        val bundle = Bundle()
        bundle.putString("newProduct", binding.tvGoNewProduct.text.toString())
    }



        binding.btnAddOrder.setOnClickListener {
            val tvDescription = binding.etDescriptionOrder.text.toString()
            viewModel.insertOrder(
                AppOrder(
                    id_users = currentUser?.user_id!!,
                    description = tvDescription,
                    date = tvDate,
                    id_product = currentProduct?.product_id!!,
                    quantity = count,
                    totalPrice = sum

                )
            )
            showToast("Insert order")
            APP_ACTIVITY.navController.navigate(R.id.action_addOrderFragment_to_navigation_orders)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                APP_ACTIVITY.navController.navigate(R.id.action_addOrderFragment_to_navigation_orders)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}