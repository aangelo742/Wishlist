package com.example.wishlist

class ItemFetcher {
    companion object {
        val names = mutableListOf("PLACEHOLDER")
        val prices = mutableListOf(1.00)
        val urls = mutableListOf("PLACEHOLDER")

        fun addNames(name: String) {
            names += name
        }

        fun addPrices(price: Double) {
            prices += price
        }

        fun addUrls(url: String) {
            urls += url
        }

        fun getItems(): MutableList<Item> {
            var items : MutableList<Item> = ArrayList()
            for (i in 1..names.size - 1) {
                val item = Item(names[i], prices[i], urls[i])
                items.add(item)
            }
            return items
        }
    }
}