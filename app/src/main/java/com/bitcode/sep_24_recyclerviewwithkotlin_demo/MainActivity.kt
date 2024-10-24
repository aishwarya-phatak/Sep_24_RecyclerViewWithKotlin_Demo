package com.bitcode.sep_24_recyclerviewwithkotlin_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForProducts : RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var products : ArrayList<Product>
    private lateinit var users : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initViews()
        initArray()
        initAdapters()
    }

    private fun initViews(){
        recyclerViewForProducts = findViewById(R.id.recyclerViewForProducts)
    }

    private fun initArray(){
        products = ArrayList<Product>()
        for (i in 0..10) {
            products.add(Product( i + 5, "Product " + i,  + i * 500.0 ))
        }

        users = ArrayList<User>()
        for (i in 0..10){
            users.add(User("User " + i, age = i * 20))
        }
    }

    private fun initAdapters(){
        productsAdapter = ProductsAdapter(products, users)
        recyclerViewForProducts.adapter = productsAdapter
        recyclerViewForProducts.layoutManager = LinearLayoutManager(this,
                                                                    LinearLayoutManager.VERTICAL,
                                                                    false)
    }
}