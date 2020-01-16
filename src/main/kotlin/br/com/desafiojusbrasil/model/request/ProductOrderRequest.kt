package br.com.desafiojusbrasil.model.request

import br.com.desafiojusbrasil.dao.ProductOrderKey

class ProductOrderRequest(val idOrder: Long,
                          val idProduct: Long) {
    fun toProductOrderKey(): ProductOrderKey = ProductOrderKey(
            idOrder,
            idProduct
    )
}