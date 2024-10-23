package com.bitcode.sep_24_recyclerviewwithkotlin_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    var products : ArrayList<Product>
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         private var imageView : ImageView
         private var txtProductName : TextView
         private var txtProductPrice : TextView

         init {
             imageView = itemView.findViewById(R.id.imgView)
             txtProductName = itemView.findViewById(R.id.productNameTxtView)
             txtProductPrice = itemView.findViewById(R.id.productPriceTextView)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
      var layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
       var productView = layoutInflater.inflate(R.layout.product_viewholder,null)
        return ProductViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product = products[position]
        holder.itemView.findViewById<ImageView>(R.id.imgView).setImageResource(R.drawable.ic_launcher_background)
        holder.itemView.findViewById<TextView>(R.id.productNameTxtView).text = product.name
        holder.itemView.findViewById<TextView>(R.id.productPriceTextView).text = " ${product.price}"
    }

    override fun getItemCount(): Int {
        return products.size
    }
}