package br.com.desafiojusbrasil.model.request

import br.com.desafiojusbrasil.dao.ProductOrderKey

class ProductOrderRequest(private val idOrder: Long,
                          private val idProduct: Long) {
    fun toProductOrderKey(): ProductOrderKey = ProductOrderKey(
            idProduct,
            idOrder)
}