package br.com.desafiojusbrasil.entity

import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        @Id @GeneratedValue var id: Long,
        @Column(name = "date_created")
        val dateCreated: String,
        @Column(name = "date_ordered")
        val dateOrdered: String,
        @OneToMany(mappedBy = "orders")
        val productOrders: List<ProductOrder>
)