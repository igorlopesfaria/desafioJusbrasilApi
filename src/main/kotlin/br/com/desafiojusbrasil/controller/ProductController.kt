package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.model.request.ProductRequest
import br.com.desafiojusbrasil.model.response.ProductItemResponse
import br.com.desafiojusbrasil.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(val productRepository: ProductRepository) {

    @GetMapping
    fun getAllProducts(): List<ProductItemResponse> {
        return productRepository.findAll().map(::ProductItemResponse)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<ProductItemResponse> =
            productRepository.findById(productId).map { product ->
                ResponseEntity(ProductItemResponse(product), HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun createProduct(@Valid @RequestBody productRequest: ProductRequest) =
            productRepository.save(productRequest.toProduct())

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<Void> =
            productRepository.findById(productId).map { product ->
                productRepository.delete(product)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

}
