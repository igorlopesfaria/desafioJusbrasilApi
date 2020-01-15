package br.com.desafiojusbrasil.model

import br.com.desafiojusbrasil.entity.Product


class ProductItem(val id: Long? = 0,
                  val name: String,
                  val price: String,
                  val description: String) {
    constructor(database: Product) : this(
            id = database.id,
            name = database.name,
            price = database.price,
            description = database.description)
}

class ProductInsert(val name: String,
                    val price: String,
                    val description: String) {
    fun toProduct(): Product = Product(
            name = name,
            price = price,
            description = description
    )
}