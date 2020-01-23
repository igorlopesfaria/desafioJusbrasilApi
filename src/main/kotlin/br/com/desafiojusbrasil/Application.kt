package br.com.desafiojusbrasil

import br.com.desafiojusbrasil.repository.OrderRepository
import br.com.desafiojusbrasil.resolvers.OrderResolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application

@Bean
fun orderResolver(orderRepository: OrderRepository): OrderResolver {
    return OrderResolver(orderRepository)
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)


}
