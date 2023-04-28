package com.example.productlistapp.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.productlistapp.adapter.ProductAdapter
import com.example.productlistapp.databinding.ActivityMainBinding
import com.example.productlistapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var productAdapter : ProductAdapter
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getProducts()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Loading ...")
        progressDialog.setCancelable(false) // blocks UI interaction
        progressDialog.show()
        viewModel.observeProductLiveData().observe(this, Observer { productList ->
            progressDialog.hide()
            productAdapter.setProductList(productList)
        })
    }

    private fun prepareRecyclerView() {
        productAdapter = ProductAdapter()
        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(applicationContext,1)
            adapter = productAdapter
        }
    }
}