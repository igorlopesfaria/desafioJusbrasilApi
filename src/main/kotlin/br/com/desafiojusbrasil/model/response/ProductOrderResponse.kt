package br.com.desafiojusbrasil.model.response

import br.com.desafiojusbrasil.dao.ProductOrder


class ProductOrderResponse(
                  val value: Double,
                  val listProductOrder: List<ProductOrderItemResponse>)