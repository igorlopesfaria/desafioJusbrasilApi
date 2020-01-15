package br.com.desafiojusbrasil.entity

import javax.persistence.*

@Entity
@Table(name = "product")
class Product(
        @Id @GeneratedValue val id: Long?= null,
        val name: String,
        val price: String,
        val description: String,
        @OneToMany(mappedBy = "product")
        val productOrders: List<ProductOrder>?= null
)
