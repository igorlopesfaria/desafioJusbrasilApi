package br.com.desafiojusbrasil.resolvers

import br.com.desafiojusbrasil.dao.Orders
import br.com.desafiojusbrasil.model.response.OrderItemResponse
import br.com.desafiojusbrasil.repository.OrderRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import java.util.*


@Component
class OrderResolver(val orderRepository: OrderRepository) : GraphQLQueryResolver{

    fun findAllOrders(): Iterable<Orders> {
        return orderRepository.findAll()
    }

    fun findClosedOrders():  Iterable<Orders> {
        return orderRepository.findClosed()
    }

}

//@Component
//class HelloWorldQuery(val orderRepository: OrderRepository): Query {
//    fun helloWorld() = "Hello World!"
//}
