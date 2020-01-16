package br.com.desafiojusbrasil.dao

import java.io.Serializable
import javax.persistence.*

@Embeddable
class ProductOrderKey(
        @Column(name = "product_id")
        val productId: Long,
        @Column(name = "order_id")
        val orderId: Long
): Serializable

@Entity
@NamedQuery(name = "ProductOrder.findByOrderId", query = "SELECT po FROM ProductOrder po WHERE order_id = (?1)")
@Table(name = "ProductOrder")
class ProductOrder(
        @EmbeddedId
        val id: ProductOrderKey,
        @ManyToOne
        @MapsId("product_id")
        @JoinColumn(name = "product_id")
        val product: Product,
        @ManyToOne
        @MapsId("order_id")
        @JoinColumn(name = "order_id")
        val orders: Orders,
        var quantity: Int = 1
)