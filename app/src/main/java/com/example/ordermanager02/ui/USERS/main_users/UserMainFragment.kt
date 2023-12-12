package com.example.ordermanager02.ui.USERS.main_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppUser
import com.example.ordermanager02.databinding.FragmentMainUserBinding
import com.example.ordermanager02.utils.APP_ACTIVITY

class UserMainFragment : Fragment() {

    private var _binding: FragmentMainUserBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserMainAdapter
    lateinit var viewModel: UserMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainUserBinding.inflate(inflater, container, false)
        recyclerView = binding.rvMainUser
        adapter = UserMainAdapter()
        recyclerView.adapter = adapter
        return (binding.root)
    }

    override fun onStart() {
        super.onStart()
        viewModel =
            ViewModelProvider(this).get(UserMainViewModel::class.java)
        viewModel.getAllUsers()
        viewModel.liveData.observe(this) { adapter.setList(it) }
        binding.btnFabUser.setOnClickListener {
                         APP_ACTIVITY.navController.navigate(R.id.action_userMainFragment_to_addUserFragment)
            }
        }

    companion object {
        fun click(user:AppUser) {
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            APP_ACTIVITY.navController.navigate(R.id.action_userMainFragment_to_detailUserFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}