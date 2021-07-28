package br.com.andressa.entrypoint.controller

import br.com.andressa.core.mappers.TodoConverter
import br.com.andressa.core.ports.TodoServicePort
import br.com.andressa.entrypoint.model.TodoRequest
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/todos")
class TodoController(private val todoServicePort: TodoServicePort) {
    val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    fun save(@Body todoRequest: TodoRequest){
        val todo = TodoConverter.todoRequestToTodo(todoRequest)
        logger.info("salvo")
        todoServicePort.save(todo)
    }

    @Put
    fun update(id: UUID, todoRequest: TodoRequest){
        val todo = TodoConverter.todoRequestToTodo(todoRequest)
        logger.info("atualizado")
        todoServicePort.update(id, todo)
    }

    @Delete
    fun delete(id: UUID){
        todoServicePort.delete(id)
    }
}