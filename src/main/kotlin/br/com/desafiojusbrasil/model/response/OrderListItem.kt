package br.com.desafiojusbrasil.model.response;

import br.com.desafiojusbrasil.entity.Orders

class OrderListItem(val id: Long? = 0,
                    val dataCreated: String,
                    val dateOrdered: String?=null) {
        constructor(database: Orders) : this(
                id = database.id,
                dataCreated = database.dateCreated,
                dateOrdered = database.dateOrdered)
}