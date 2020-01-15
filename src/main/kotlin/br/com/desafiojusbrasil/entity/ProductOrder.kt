package br.com.desafiojusbrasil.entity

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
@NamedQuery(name = "ProductOrder.findByOrderId", query = "SELECT po FROM product_order po WHERE order_id = (?1)")
@Table(name = "product_order")
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
        val order: Order,
        val quantity: Int
)