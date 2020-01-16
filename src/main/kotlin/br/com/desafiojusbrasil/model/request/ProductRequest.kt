package br.com.desafiojusbrasil.model.request

import br.com.desafiojusbrasil.dao.Product

class ProductRequest(val name: String,
                     val price: String,
                     val description: String) {
    fun toProduct(): Product = Product(
            name = name,
            price = price,
            description = description
    )
}