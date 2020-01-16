package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.model.request.ProductInsert
import br.com.desafiojusbrasil.model.response.ProductListItem
import br.com.desafiojusbrasil.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(val productRepository: ProductRepository){

    @GetMapping
    fun getAllProducts(): List<ProductListItem>{
        return productRepository.findAll().map(::ProductListItem)
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody productInsert: ProductInsert) =
            productRepository.save(productInsert.toProduct())

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable(value = "id") categoriaId: Long): ResponseEntity<Void> =
            productRepository.findById(categoriaId).map { product ->
                productRepository.delete(product)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

}
