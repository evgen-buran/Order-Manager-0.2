package com.example.ordermanager02.ui.ORDERS.add_new_order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.ordermanager02.database.AppUser

class ListUserAdapter(context: Context, users: List<AppUser>) : ArrayAdapter<AppUser>(
    context,
    android.R.layout.simple_dropdown_item_1line,
    users.toMutableList()
) {
    private var user: AppUser? = null
    private val users = users

    override fun getItemId(position: Int): Long {
        return (getItem(position)?.user_id?.toLong() ?: -1)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        user = getItem(position)
        val view = LayoutInflater.from(context)
            .inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        val textView = view.findViewById(android.R.id.text1) as TextView
        textView.text = user?.nameUser
        return view
    }


    fun getUserById(id: Long): AppUser? {
//        users.forEach{if(it.user_id.toLong() == id) return user}  - потому что перебирает, весь список, даже если нашел нужный объект
        for (i in users) {
            if (i.user_id.toLong() == id) return i
        }
        return null
    }

    fun setList(list: List<AppUser>) {
        clear()
        addAll(list)
        notifyDataSetChanged()
    }

}