package com.example.ordermanager02.ui.ORDERS.add_new_order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.ordermanager02.database.AppProduct

class ListProductAdapter(context: Context, products: List<AppProduct>) :
    ArrayAdapter<AppProduct>(
        context,
        android.R.layout.simple_dropdown_item_1line,
        products.toMutableList()
    ) {
    private var product: AppProduct? = null
    private val listProducts = products

    override fun getItemId(position: Int): Long {
        return getItem(position)?.product_id?.toLong() ?: -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        product = getItem(position)
        val view = LayoutInflater.from(context)
            .inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        val textView: TextView = view.findViewById(android.R.id.text1)
        textView.text = product?.nameProduct
        return view
    }

    fun getProductById(id: Long): AppProduct? {
        for (i in listProducts) {
            if (i.product_id.toLong() == id) return i
        }
        return null
    }
}


