package br.com.andressa.core.service

import br.com.andressa.core.mappers.TodoConverter
import br.com.andressa.core.model.Todo
import br.com.andressa.core.ports.TodoServicePort
import br.com.andressa.infrastructure.service.TodoServiceInfra
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton


@Singleton
class TodoServiceImpl(private val todoServiceInfra: TodoServiceInfra): TodoServicePort {

    val logger = LoggerFactory.getLogger(this::class.java)

    override fun save(todo: Todo) {
        logger.info("chegou na core")
        val todoEvent = TodoConverter.todoToTodoEvent(todo)
        todoServiceInfra.save(todoEvent)

    }

    override fun update(id: UUID, todo: Todo) {
        val todoEvent = TodoConverter.todoToTodoEvent(todo)
        todoServiceInfra.update(id,todoEvent)
    }

    override fun delete(id: UUID) {
        todoServiceInfra.delete(id)
    }
}