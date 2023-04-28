package com.example.productlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.productlistapp.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val category = intent.getStringExtra("category")
        val description = intent.getStringExtra("description")
        val id = intent.getIntExtra("id", 1)
        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val price = intent.getDoubleExtra("price", 10.00)
        binding.category.text = category
        binding.description.text = description
        binding.id.text = id.toString()
        binding.price.text = price.toString()
        binding.title.text = title

        Glide.with(this)
            .load(image)
            .into(binding.ivProductPoster)
    }

}