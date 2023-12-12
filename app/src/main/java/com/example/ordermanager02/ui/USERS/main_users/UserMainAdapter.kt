package com.example.ordermanager02.ui.USERS.main_users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppUser

class UserMainAdapter : RecyclerView.Adapter<UserMainAdapter.MainUserHolder>() {
    private var listUser: List<AppUser> = emptyList()

    class MainUserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIdUserItem: TextView = itemView.findViewById(R.id.tvIdUserItem)
        val tvNameUserItem: TextView = itemView.findViewById(R.id.tvNameUserItem)
        val tvSecondNameUserItem: TextView = itemView.findViewById(R.id.tvSecondNameUserItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainUserHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_user_item, parent, false)
        return MainUserHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: MainUserHolder, position: Int) {
        holder.tvIdUserItem.text = listUser.get(position).user_id.toString()
        holder.tvNameUserItem.text = listUser.get(position).nameUser.toString()
        holder.tvSecondNameUserItem.text = listUser.get(position).secondNameUser.toString()
    }

    fun setList(list: List<AppUser>) {
        listUser = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainUserHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener { UserMainFragment.click(listUser.get(holder.adapterPosition)) }
    }

    override fun onViewDetachedFromWindow(holder: MainUserHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}