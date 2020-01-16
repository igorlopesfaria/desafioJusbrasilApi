package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.model.response.ProductOrderItem
import br.com.desafiojusbrasil.repository.ProductOrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/productOrders")
class ProductOrderController(val productOrderRepository: ProductOrderRepository){

    @GetMapping("/orders/{order_id}")
    fun getProductOrderByOrderId(@PathVariable(value = "order_id") orderId: Long): List<ProductOrderItem>{
        return productOrderRepository.findByOrderId(orderId).map(::ProductOrderItem)
    }
}
