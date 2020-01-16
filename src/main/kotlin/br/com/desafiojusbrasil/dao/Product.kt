package br.com.desafiojusbrasil.dao

import javax.persistence.*

@Entity
@Table(name = "Product")
class Product(
        @Id @GeneratedValue val id: Long?= null,
        val name: String,
        val price: String,
        val description: String,
        @OneToMany(mappedBy = "product")
        val productOrders: List<ProductOrder>?= null
)
