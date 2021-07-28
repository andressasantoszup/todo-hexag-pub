package br.com.andressa.infrastructure.service

import br.com.andressa.infrastructure.model.TodoEvent
import java.util.*


interface TodoServiceInfra {

    fun save(todoEvent: TodoEvent)
    fun update(id: UUID, todoEvent: TodoEvent)
    fun delete (id: UUID)
}