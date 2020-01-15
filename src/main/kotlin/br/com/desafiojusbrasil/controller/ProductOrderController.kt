package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.model.OrderItem
import br.com.desafiojusbrasil.model.ProductItem
import br.com.desafiojusbrasil.repository.OrderRepository
import br.com.desafiojusbrasil.repository.ProductOrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/productOrders")
class ProductOrderController(val productOrderRepository: ProductOrderRepository){


}
