package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.entity.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Orders, Long>{
    fun findOpened(): Orders

}
