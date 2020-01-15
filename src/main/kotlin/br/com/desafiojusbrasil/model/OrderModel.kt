package br.com.desafiojusbrasil.model;

import br.com.desafiojusbrasil.entity.Order

class OrderOpened(val id: Long? = 0,
                  val dataCreated: String,
                  val dateOrdered: String?=null) {
        constructor(database: Order) : this(
                id = database.id,
                dataCreated = database.dateCreated,
                dateOrdered = database.dateOrdered)
}