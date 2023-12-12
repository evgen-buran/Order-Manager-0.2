package com.example.ordermanager02.ui.PRODUCTS.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ordermanager02.R
import com.example.ordermanager02.database.AppProduct
import com.example.ordermanager02.database.AppUser

class ProductMainAdapter: RecyclerView.Adapter<ProductMainAdapter.ProductMainHolder>() {
    private var listProducts:List<AppProduct> = emptyList()

    class ProductMainHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tvNameProduct = view.findViewById<TextView>(R.id.tvNameProduct)
        val tvDescriptionProduct = view.findViewById<TextView>(R.id.tvDescriptionProduct)
        val tvPriceProduct = view.findViewById<TextView>(R.id.tvPriceProduct)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductMainHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_product_item, parent, false)
        return ProductMainHolder(view)
    }

    override fun getItemCount(): Int {
       return listProducts.size
    }

    override fun onBindViewHolder(holder: ProductMainHolder, position: Int) {
        holder.tvNameProduct.text = listProducts.get(position).nameProduct
        holder.tvDescriptionProduct.text = listProducts.get(position).descriptionProduct
        holder.tvPriceProduct.text = listProducts.get(position).priceProduct.toString()
    }

    override fun onViewAttachedToWindow(holder: ProductMainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{ProductMainFragment.click(listProducts.get(holder.adapterPosition))}
    }
    fun setList(list: List<AppProduct>) {
        listProducts = list
        notifyDataSetChanged()
    }

}
