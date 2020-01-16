package br.com.desafiojusbrasil.model.response

import br.com.desafiojusbrasil.entity.Product

class ProductListItem (val id: Long? = 0,
                   val name: String,
                   val price: String,
                   val description: String) {
    constructor(database: Product) : this(
            id = database.id,
            name = database.name,
            price = database.price,
            description = database.description)
}