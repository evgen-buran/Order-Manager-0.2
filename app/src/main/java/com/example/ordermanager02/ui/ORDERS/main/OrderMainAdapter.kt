package com.example.ordermanager02.ui.ORDERS.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.JoinOrder

class OrderMainAdapter : RecyclerView.Adapter<OrderMainAdapter.MainHolder>() {
    private var listOrders: List<JoinOrder> = emptyList()

    class MainHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tvIdOrderItem: TextView = view.findViewById(R.id.tvIdOrderItem)
        val tvOrderUserItem: TextView = view.findViewById(R.id.tvOrderUserItem)
        val tvDescripOrderItem: TextView = view.findViewById(R.id.tvDescripOrderItem)
        val tvDateOrderItem: TextView = view.findViewById(R.id.tvDateOrderItem)
        val tvNameProductOrderItem: TextView = view.findViewById(R.id.tvNameProductOrderItem)
        val tvCountProductOrderItem: TextView = view.findViewById(R.id.tvCountProductOrderItem)
        val tvPriceProductOrderItem: TextView = view.findViewById(R.id.tvPriceProductOrderItem)
        val tvSumOrderItem: TextView = view.findViewById(R.id.tvSumOrderItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_order_item, parent, false)
        return MainHolder(view)
    }
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.tvIdOrderItem.text = listOrders[position].id.toString()
        holder.tvOrderUserItem.text = listOrders[position].nameUser + " " + listOrders[position].secondNameUser
        holder.tvDescripOrderItem.text = listOrders[position].description
        holder.tvDateOrderItem.text = listOrders[position].date
        holder.tvNameProductOrderItem.text = listOrders[position].nameProduct
        holder.tvCountProductOrderItem.text = listOrders[position].quantity.toString()
        holder.tvPriceProductOrderItem.text = listOrders[position].priceProduct.toString()
        holder.tvSumOrderItem.text = listOrders[position].calculateTotalPrice().toString()

    }


    override fun getItemCount(): Int {
        return listOrders.size
    }

    fun setList(list: List<JoinOrder>) {
        listOrders = list
        notifyDataSetChanged()

    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{OrderMainFragment.clickItemList(listOrders[holder.adapterPosition])}
    }
}
