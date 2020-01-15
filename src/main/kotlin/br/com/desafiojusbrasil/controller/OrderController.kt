package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.entity.Order
import br.com.desafiojusbrasil.model.OrderOpened
import br.com.desafiojusbrasil.model.ProductOrderItem
import br.com.desafiojusbrasil.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(val orderRepository: OrderRepository){

    @GetMapping("/filters")
    fun findOrderByStatus(): Order {
        val order = orderRepository.findOpened()
        return order;
    }

}
