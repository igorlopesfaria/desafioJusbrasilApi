package br.com.desafioju

import br.com.desafiojusbrasil.Application
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
@SpringBootTest(classes = arrayOf(Application::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductController {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun requestProductList_ListOfProductShouldBeDisplayed() {
        val result = testRestTemplate.getForEntity("/products", ArrayList::class.java)
        assertNotNull(result)
        assert(result.statusCode == HttpStatus.OK)
    }

    @Test
    fun requestProductListByCorrectId_ObjectProductShouldBeDisplayed() {
        val result = testRestTemplate.getForEntity("/products/1", Any::class.java)
        assertNotNull(result)
        assert(result.statusCode == HttpStatus.OK)

    }

    @Test
    fun requestProductListByWrongId_HttpCode404SHouldBeDisplayed() {
        val result = testRestTemplate.getForEntity("/products/-1", Any::class.java)
        assertNotNull(result)
        assert(result.statusCode == HttpStatus.NOT_FOUND)
    }


}