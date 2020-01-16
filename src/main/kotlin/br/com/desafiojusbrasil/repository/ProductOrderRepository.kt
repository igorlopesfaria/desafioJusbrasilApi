package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.dao.ProductOrder
import br.com.desafiojusbrasil.dao.ProductOrderKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductOrderRepository: JpaRepository<ProductOrder, ProductOrderKey>{

    fun findByOrderId(idOrder: Long): List<ProductOrder>

}
