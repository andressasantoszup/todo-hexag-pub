package br.com.andressa.infrastructure.service

import br.com.andressa.core.mappers.TodoConverter
import br.com.andressa.infrastructure.client.TodoClient
import br.com.andressa.infrastructure.model.Events
import br.com.andressa.infrastructure.model.EventsInformation
import br.com.andressa.infrastructure.model.TodoEvent
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton


@Singleton
class TodoServiceInfraImpl(private val todoClient: TodoClient): TodoServiceInfra {

    val logger = LoggerFactory.getLogger(this::class.java)

    override fun save(todoEvent: TodoEvent) {

        logger.info("chegou na infra")
        todoClient.send(EventsInformation(Events.SAVE,todoEvent))
    }

    override fun update(id: UUID, todoEvent: TodoEvent) {
        todoClient.send(EventsInformation(Events.UPDATE,todoEvent))
    }

    override fun delete(id: UUID) {
        val todoEvent = EventsInformation(Events.DELETE, TodoEvent(id))
        todoClient.send(todoEvent)
    }
}