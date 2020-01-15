package br.com.desafiojusbrasil.model;

import br.com.desafiojusbrasil.entity.Order

class OrderItem(val id: Long? = 0,
                  val dataCreated: String,
                  val dateOrdered: String) {
        constructor(database: Order) : this(
                id = database.id,
                dataCreated = database.dateCreated,
                dateOrdered = database.dateOrdered)
}