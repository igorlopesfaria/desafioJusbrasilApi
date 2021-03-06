package br.com.desafiojusbrasil.model.response

import br.com.desafiojusbrasil.dao.Product

class ProductItemResponse (val id: Long? = 0,
                           val name: String,
                           val price: Double,
                           val imagePath: String,
                           val description: String) {
    constructor(database: Product) : this(
            id = database.id,
            name = database.name,
            price = database.price,
            imagePath= database.imagePath,
            description = database.description)
}