package com.example.ordermanager02.ui.USERS.add_user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.databinding.FragmentAddUserBinding
import com.example.ordermanager02.utils.APP_ACTIVITY
import com.example.ordermanager02.utils.showToast

class AddUserFragment : Fragment() {
    private val TAG = "myLogs"
    private var _binding: FragmentAddUserBinding? = null
    val binding get() = _binding!!
    lateinit var viewModel: AddUserViewModel
    var destination: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentAddUserBinding.inflate(layoutInflater, container, false)
        binding.etFirstName.setText(arguments?.getString("newName"))

        binding.etFirstName.requestFocus()
        setHasOptionsMenu(true)
        (arguments?.getString("newName")?.length
            ?: null)?.let { binding.etFirstName.setSelection(it) } // так правильнее, не будет исключения
//        binding.etFirstName.setSelection(arguments?.getString("newName")?.length!!) - исключение, если сразу заходить добавить пользователя
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        destination =
            arguments?.getInt("destinationOrder")?:R.id.action_addUserFragment_to_userMainFragment2
        Log.d(TAG, "onStart: $destination")
        viewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)
        addUser()


    }

    private fun addUser() {
        binding.btnAddUser.setOnClickListener {
            val nameUser = binding.etFirstName.text.toString()
            val secondNameUser = binding.etSecondName.text.toString()

            if (nameUser.isEmpty()) {
                showToast("Name is empty!")
            } else {
                viewModel.insert(AppUser(nameUser = nameUser, secondNameUser = secondNameUser))
                Log.d(TAG, "onStart2: $destination")
                APP_ACTIVITY.navController.navigate(destination)
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                APP_ACTIVITY.navController.navigate(R.id.action_addUserFragment_to_userMainFragment2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}