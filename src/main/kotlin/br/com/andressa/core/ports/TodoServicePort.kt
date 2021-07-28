package br.com.andressa.core.ports

import br.com.andressa.core.model.Todo
import java.util.*


interface TodoServicePort {

    fun save(todo: Todo)
    fun update(id: UUID, todo: Todo)
    fun delete(id: UUID)
}