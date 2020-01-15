package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.entity.Order
import br.com.desafiojusbrasil.entity.ProductOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long>{
    fun findOpened(): Order

}
