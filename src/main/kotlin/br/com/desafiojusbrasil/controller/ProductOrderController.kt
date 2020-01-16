package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.dao.ProductOrder
import br.com.desafiojusbrasil.dao.ProductOrderKey
import br.com.desafiojusbrasil.model.request.ProductOrderRequest
import br.com.desafiojusbrasil.model.response.ProductOrderItemResponse
import br.com.desafiojusbrasil.repository.OrderRepository
import br.com.desafiojusbrasil.repository.ProductOrderRepository
import br.com.desafiojusbrasil.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/productOrders")
class ProductOrderController(val productOrderRepository: ProductOrderRepository,
                             val productRepository: ProductRepository,
                             val orderRepository: OrderRepository) {

    @GetMapping("/order/{order_id}")
    fun getProductOrderByOrderId(@PathVariable(value = "order_id") orderId: Long): List<ProductOrderItemResponse> {
        return productOrderRepository.findByOrderId(orderId).map(::ProductOrderItemResponse)
    }

    @GetMapping
    fun getAllProductOrder(): List<ProductOrderItemResponse> = productOrderRepository.findAll().map(::ProductOrderItemResponse)

    @PostMapping
    fun createProductOrder(@Valid @RequestBody productOrderRequest: ProductOrderRequest): ResponseEntity<Void> {
        val productOrderKey = productOrderRequest.toProductOrderKey()

        val productOrderOptional = productOrderRepository.findById(productOrderKey)
        val orderOptional = orderRepository.findById(productOrderKey.orderId)

        if(orderOptional.isPresent && !orderOptional.get().dateOrdered.isNullOrEmpty()){
            return ResponseEntity.badRequest().build()
        }

        if (productOrderOptional.isPresent) {
            val productOrder = productOrderOptional.get()
            productOrder.quantity = productOrder.quantity + 1
            productOrderRepository.save(productOrder)
            return ResponseEntity(HttpStatus.OK)
        } else {

            val productOptional = productRepository.findById(productOrderKey.productId)

            if (productOptional.isPresent && orderOptional.isPresent) {
                productOrderRepository.save(ProductOrder(
                        productOrderKey,
                        productOptional.get(),
                        orderOptional.get()
                ))
                return ResponseEntity(HttpStatus.OK)
            } else {
                return ResponseEntity.notFound().build()
            }

        }
    }

    @DeleteMapping("/order/{order_id}/product/{product_id}")
    fun deleteProductOrderById(@PathVariable(value = "order_id") orderId: Long,
                               @PathVariable(value = "product_id") productId: Long): ResponseEntity<Void> =
            productOrderRepository.findById(ProductOrderKey(productId, orderId)).map { productOrder ->
                productOrderRepository.delete(productOrder)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())


}
