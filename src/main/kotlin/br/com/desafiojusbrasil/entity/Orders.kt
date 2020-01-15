package br.com.desafiojusbrasil.entity

import javax.persistence.*

@Entity
@NamedQuery(name = "Orders.findOpened", query = "SELECT o FROM Orders o WHERE dateOrdered IS NULL")
@Table(name = "Orders")
class Orders(
        @Id @GeneratedValue var id: Long,
        @Column(name = "date_created")
        val dateCreated: String,
        @Column(name = "date_ordered")
        val dateOrdered: String,
        @OneToMany(mappedBy = "orders")
        val productOrders: List<ProductOrder>
)