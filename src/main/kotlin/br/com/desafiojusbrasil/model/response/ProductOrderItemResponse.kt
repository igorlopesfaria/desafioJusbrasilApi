package br.com.desafiojusbrasil.model.response

import br.com.desafiojusbrasil.dao.ProductOrder

class ProductOrderItemResponse(
                  val idProduct: Long,
                  val idOrder: Long,
                  val productName: String,
                  val productPrice: Double,
                  val productImagePath: String,
                  val quantity: Int) {
    constructor(database: ProductOrder) : this(
            idProduct = database.id.productId,
            idOrder = database.id.orderId,
            productName = database.product.name,
            productPrice = database.product.price,
            productImagePath = database.product.imagePath,
            quantity = database.quantity)
}

