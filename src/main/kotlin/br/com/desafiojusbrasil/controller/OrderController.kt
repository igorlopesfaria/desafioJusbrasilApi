package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.repository.OrderRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(val orderRepository: OrderRepository){

}
