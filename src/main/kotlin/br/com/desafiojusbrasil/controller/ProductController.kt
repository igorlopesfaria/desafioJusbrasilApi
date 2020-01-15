package br.com.desafiojusbrasil.controller

import br.com.desafiojusbrasil.model.ProductInsert
import br.com.desafiojusbrasil.repository.ProductRepository
import br.com.desafiojusbrasil.model.ProductItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(val productRepository: ProductRepository){

    @GetMapping
    fun getAllProducts(): List<ProductItem>{
        return productRepository.findAll().map(::ProductItem)
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
