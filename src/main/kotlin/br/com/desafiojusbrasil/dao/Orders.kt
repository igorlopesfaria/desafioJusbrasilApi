package br.com.desafiojusbrasil.dao

import javax.persistence.*

@Entity
@NamedQuery(name = "Orders.findOpened", query = "SELECT o FROM Orders o WHERE dateOrdered IS NULL")
@Table(name = "Orders")
class Orders(
        @Id @GeneratedValue var id: Long?= null,
        @Column(name = "date_created")
        val dateCreated: String,
        @Column(name = "date_ordered")
        var dateOrdered: String?=null,
        @OneToMany(mappedBy = "orders")
        val productOrders: List<ProductOrder>?= null
)