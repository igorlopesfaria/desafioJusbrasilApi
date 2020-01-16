package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.Application
import br.com.desafiojusbrasil.dao.Product
import org.assertj.core.api.Assertions.assertThat
import org.hibernate.validator.internal.util.Contracts
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@ExtendWith(MockitoExtension::class)
@Transactional
@SpringBootTest(classes = arrayOf(Application::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRepositoryTest {

    companion object {
        const val PRODUCT_NAME_VALUE = "Product Name"
        const val PRODUCT_DESCRIPTION_VALUE = "Product Description"
        const val PRODUCT_PRICE_VALUE = 0.0
    }

    val templateProduct = Product(name = PRODUCT_NAME_VALUE,
            price = PRODUCT_PRICE_VALUE,
            description = PRODUCT_DESCRIPTION_VALUE)

    @Autowired
    lateinit var productRepository: ProductRepository

    @Rollback(true)
    @Test
    fun saveProductWhithCorrectValues_InsertShouldBeDone() {
        val product = productRepository.save(templateProduct)

        assertThat(product.name).isEqualTo(PRODUCT_NAME_VALUE);
        assertThat(product.price).isEqualTo(PRODUCT_PRICE_VALUE);
        assertThat(product.description).isEqualTo(PRODUCT_DESCRIPTION_VALUE);
        assertNotNull(product.id)
    }

    @Test
    fun findAllProducts_AllListShouldBeShowed() {
        val productList = productRepository.findAll()
        assertNotNull(productList)
    }

    @Rollback(true)
    @Test
    fun findProductByCorrectId_ObjectShouldBeShowed() {
        val productInserted = productRepository.save(templateProduct)
        assertNotNull(productInserted.id)

        val productOptional = productRepository.findById(productInserted.id!!)
        assert(productOptional.isPresent)
        assertThat(productOptional.get().name).isEqualTo(PRODUCT_NAME_VALUE);
        assertThat(productOptional.get().price).isEqualTo(PRODUCT_PRICE_VALUE);
        assertThat(productOptional.get().description).isEqualTo(PRODUCT_DESCRIPTION_VALUE);
        assertNotNull(productOptional.get().id)
    }


    @Rollback(true)
    @Test
    fun `findProductByWrongId_ObjectShouldn'tBeShowed`() {
        val product = productRepository.findById(-1000)
        assert(!product.isPresent);
    }

    @Rollback(true)
    @Test
    fun deleteProductByCorrectId_ObjectShouldBeDeleted() {
        val productInserted = productRepository.save(templateProduct)
        assertNotNull(productInserted.id)


        productRepository.deleteById(productInserted.id!!)
        val productOptional = productRepository.findById(productInserted.id!!)
        assert(!productOptional.isPresent)
    }
}