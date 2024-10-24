package com.bitcode.sep_24_recyclerviewwithkotlin_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class ProductsAdapter(
    var products : ArrayList<Product>,
    var users : ArrayList<User>
) : RecyclerView.Adapter<ViewHolder>() {

    val VIEW_PRODUCT = 1
    val VIEW_USER = 2

    class ProductViewHolder(itemView: View) : ViewHolder(itemView){
         private var imageView : ImageView
         private var txtProductName : TextView
         private var txtProductPrice : TextView

         init {
             imageView = itemView.findViewById(R.id.imgView)
             txtProductName = itemView.findViewById(R.id.productNameTxtView)
             txtProductPrice = itemView.findViewById(R.id.productPriceTextView)
         }
    }

    class UserViewHolder(itemView: View) : ViewHolder(itemView) {
        private var txtUserName : TextView
        private var txtAge : TextView

        init {
            txtUserName = itemView.findViewById(R.id.txtUserName)
            txtAge = itemView.findViewById(R.id.txtAge)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0){
            return VIEW_PRODUCT
        } else {
            return VIEW_USER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      if (viewType == 1) {
          var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
          var productView = layoutInflater.inflate(R.layout.product_viewholder, null)
          return ProductViewHolder(productView)
      } else {
          var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
          var userView = layoutInflater.inflate(R.layout.user_viewholder, null)
          return UserViewHolder(userView)
      }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            var product = products[position - position / 2]

            holder.itemView.findViewById<ImageView>(R.id.imgView)
                .setImageResource(R.drawable.ic_launcher_background)
            holder.itemView.findViewById<TextView>(R.id.productNameTxtView).text = product.name
            holder.itemView.findViewById<TextView>(R.id.productPriceTextView).text =
                " ${product.price}"
        }else {
            var user = users[(position - 1) / 2]
            holder.itemView.findViewById<TextView>(R.id.txtUserName).text = user.username
            holder.itemView.findViewById<TextView>(R.id.txtAge).text = " ${user.age} "
        }
    }

    override fun getItemCount(): Int {
        return products.size + users.size
    }
}