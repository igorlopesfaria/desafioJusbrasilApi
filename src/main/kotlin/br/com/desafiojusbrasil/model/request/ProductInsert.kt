package br.com.desafiojusbrasil.model.request

import br.com.desafiojusbrasil.entity.Product

class ProductInsert(val name: String,
                    val price: String,
                    val description: String) {
    fun toProduct(): Product = Product(
            name = name,
            price = price,
            description = description
    )
}