package br.com.desafiojusbrasil.repository

import br.com.desafiojusbrasil.dao.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long>
