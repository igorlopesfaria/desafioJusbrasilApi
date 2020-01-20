package br.com.desafiojusbrasil.model.request

import br.com.desafiojusbrasil.dao.Product

class ProductRequest(val name: String,
                     val price: Double,
                     val description: String,
                     val imagePath: String) {
    fun toProduct(): Product = Product(
            name = name,
            price = price,
            description = description,
            imagePath = imagePath
    )
}