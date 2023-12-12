package com.example.ordermanager02.ui.USERS.detail_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.databinding.FragmentDetailUserBinding
import com.example.ordermanager02.utils.APP_ACTIVITY

class DetailUserFragment : Fragment() {
    private var _binding: FragmentDetailUserBinding? = null
    val binding: FragmentDetailUserBinding
        get() = _binding!!
    lateinit var currentUser: AppUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailUserBinding.inflate(layoutInflater, container, false)
        currentUser = arguments?.getSerializable("user") as AppUser
        binding.tvIdUserDetail.text = currentUser.user_id.toString()
        binding.tvNameDetail.text = currentUser.nameUser
        binding.tvSecondNameDetail.text = currentUser.secondNameUser
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                APP_ACTIVITY.navController.navigate(R.id.action_detailUserFragment_to_userMainFragment2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}