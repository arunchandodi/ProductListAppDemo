package com.example.productlistapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.productlistapp.api.RetrofitInstance
import com.example.productlistapp.model.Products
import com.example.productlistapp.model.ProductsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
	private var productLiveData = MutableLiveData<List<ProductsItem>>()

	fun getProducts() {
		RetrofitInstance.api.getProducts().enqueue(object :
		Callback<Products> {
		override fun onResponse(call: Call<Products>, response: Response<Products>) {
					if (response.body()!=null){
						productLiveData.value = response.body()!!
					}
			else{
				return
					}
		}
		override fun onFailure(call: Call<Products>, t: Throwable) {
				Log.d("TAG",t.message.toString())
		}
	})
}
	fun observeProductLiveData() : LiveData<List<ProductsItem>> {
		return productLiveData
	}
}
