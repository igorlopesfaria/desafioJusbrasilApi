package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.dao.Orders
import br.com.desafiojusbrasil.model.response.OrderItemResponse
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
    fun findOrderOpened(): ResponseEntity<OrderItemResponse> =
            orderRepository.findOpened().map {
                ResponseEntity(OrderItemResponse(it), HttpStatus.OK)
            }.orElse(
                    ResponseEntity( HttpStatus.OK)
            )

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable(value = "id") orderId: Long): ResponseEntity<OrderItemResponse> =
            orderRepository.findById(orderId).map { order ->
                ResponseEntity(OrderItemResponse(order), HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

    @GetMapping
    fun getAllOrders(): List<OrderItemResponse> = orderRepository.findAll().map(::OrderItemResponse)

    @PostMapping
    fun createOrder(): ResponseEntity<Void> {

        if (orderRepository.findOpened().isPresent) {
            return ResponseEntity.badRequest().build()
        } else {
            orderRepository.save(Orders(
                    dateCreated = getNowDateFormat()
            ))
            return ResponseEntity(HttpStatus.OK)
        }
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable(value = "id") orderId: Long): ResponseEntity<Void> =
            orderRepository.findById(orderId).map { orders ->
                orders.dateOrdered = getNowDateFormat()
                orderRepository.save(orders)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteOrderById(@PathVariable(value = "id") orderId: Long): ResponseEntity<Void> =
            orderRepository.findById(orderId).map { order ->
                orderRepository.delete(order)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())


    private fun getNowDateFormat(): String = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())

}
