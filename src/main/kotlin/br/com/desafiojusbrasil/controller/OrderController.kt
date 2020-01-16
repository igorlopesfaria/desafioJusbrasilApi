package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.entity.Orders
import br.com.desafiojusbrasil.model.response.OrderListItem
import br.com.desafiojusbrasil.repository.OrderRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController(val orderRepository: OrderRepository) {

    @GetMapping("/opened")
    fun findOrderOpened(): ResponseEntity<Orders> =
            orderRepository.findOpened().map {
                ResponseEntity(it, HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

    @GetMapping
    fun getAllProducts(): List<OrderListItem> = orderRepository.findAll().map(::OrderListItem)


    @PostMapping
    fun createOrder() {
        orderRepository.save(Orders(
                dateCreated = getNowDateFormat()
        ))
    }

    @PutMapping("/{id}")
    fun createProduct(@PathVariable(value = "id") orderId: Long): ResponseEntity<Void> =
            orderRepository.findById(orderId).map { orders ->
                orders.dateOrdered = getNowDateFormat()
                orderRepository.save(orders)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable(value = "id") orderId: Long): ResponseEntity<Void> =
            orderRepository.findById(orderId).map { product ->
                orderRepository.delete(product)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())


    private fun getNowDateFormat(): String = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())

}
