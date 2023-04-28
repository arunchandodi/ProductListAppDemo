package com.example.productlistapp.api

import com.example.productlistapp.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

	@GET("products?")
	fun getProducts() : Call<Products>
}
