package com.example.productlistapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productlistapp.databinding.ProductLayoutBinding
import com.example.productlistapp.model.Products
import com.example.productlistapp.ui.ProductDetailsActivity
import com.example.productlistapp.model.ProductsItem

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var productList = ArrayList<ProductsItem>()
    fun setProductList(productList: List<ProductsItem>) {
        this.productList = productList as ArrayList<ProductsItem>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProductLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(productList[position].image)
            .into(holder.binding.productImage)
        holder.binding.productName.text = productList[position].title
        val activity = holder.itemView.context as Activity

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, ProductDetailsActivity::class.java)
            intent.putExtra("category", productList[position].category)
            intent.putExtra("description", productList[position].description)
            intent.putExtra("id", productList[position].id)
            intent.putExtra("image", productList[position].image)
            intent.putExtra("price", productList[position].price)
            intent.putExtra("title", productList[position].title)
            activity.startActivity(intent)
            })
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
