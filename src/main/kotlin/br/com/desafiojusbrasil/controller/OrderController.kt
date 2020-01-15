package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.entity.Orders
import br.com.desafiojusbrasil.repository.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(val orderRepository: OrderRepository){

    @GetMapping("/filters")
    fun findOrderByStatus(): Orders {
        val order = orderRepository.findOpened()
        return order;
    }

}
