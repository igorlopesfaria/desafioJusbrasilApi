package br.com.desafiojusbrasil.model

import br.com.desafiojusbrasil.entity.ProductOrder


class ProductOrderItem(
                  private val idProduct: Long,
                  private val idOrder: Long,
                  private val productName: String,
                  private val productPrice: String,
                  private val quantity: Int) {
    constructor(database: ProductOrder) : this(
            idProduct = database.id.productId,
            idOrder = database.id.orderId,
            productName = database.product.name,
            productPrice = database.product.price,
            quantity = database.quantity)
}

