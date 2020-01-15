package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.entity.Order
import br.com.desafiojusbrasil.entity.ProductOrder
import br.com.desafiojusbrasil.entity.ProductOrderKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductOrderRepository: JpaRepository<ProductOrder, ProductOrderKey>
