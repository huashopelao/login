package com.example.login20.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login20.view.home.product.Product

class ProductViewModel: ViewModel (){

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init{
        loadProducts()
    }

    private fun loadProducts() {

        _products.value = listOf(
            Product( id = "1a", name = "Motor de partida", description = "12v marca bosch", price = 9.990),
            Product( id = "2b", name = "Alternador", description = "24v marca delco", price = 9.990 ),
        )

    }




}