package br.com.andressa.infrastructure.client

import br.com.andressa.infrastructure.model.EventsInformation
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject


@NatsClient
interface TodoClient {

    @Subject("todo.scheduled")
    fun send(eventsInformation: EventsInformation)

}