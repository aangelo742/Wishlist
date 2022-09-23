package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var wishlist: List<Item>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

        wishlist = ItemFetcher.getItems()
        val adapter = ItemAdapter(wishlist)

        wishlistRv.adapter = adapter

        wishlistRv.layoutManager = LinearLayoutManager(this)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val price = findViewById<EditText>(R.id.userInputPrice)
        val name = findViewById<EditText>(R.id.userInputName)
        val URL = findViewById<EditText>(R.id.userInputURL)

        submitButton.setOnClickListener {
            Log.d("test", "being clicked!")
            Log.d("price", price.length().toString())
            Log.d("price double", price.text.toString().toDouble().toString())
            Log.d("name", name.length().toString())
            Log.d("URL", URL.length().toString())
            if(price.length() > 0 && name.length() > 0 && URL.length() > 0) {
                var priceDouble = price.text.toString()
                Log.d("double price inside", priceDouble)
                Log.d("test", "You passed!")

                ItemFetcher.addNames(name.text.toString())
                ItemFetcher.addUrls(URL.text.toString())
                ItemFetcher.addPrices(price.text.toString().toDouble())
                println(ItemFetcher.prices)

                price.text.clear()
                name.text.clear()
                URL.text.clear()

                val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)

                wishlist = ItemFetcher.getItems()
                val adapter = ItemAdapter(wishlist)

                wishlistRv.adapter = adapter

                wishlistRv.layoutManager = LinearLayoutManager(this)
            }
        }

    }
}