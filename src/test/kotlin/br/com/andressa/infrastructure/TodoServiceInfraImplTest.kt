package br.com.andressa.infrastructure

import br.com.andressa.infrastructure.client.TodoClient
import br.com.andressa.infrastructure.model.Events
import br.com.andressa.infrastructure.model.EventsInformation
import br.com.andressa.infrastructure.model.TodoEvent
import br.com.andressa.infrastructure.service.TodoServiceInfraImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class TodoServiceInfraImplTest: AnnotationSpec() {

    val client = mockk<TodoClient>()
    val service = TodoServiceInfraImpl(client)

    lateinit var todoEvent: TodoEvent
    lateinit var eventsInformationSave: EventsInformation
    lateinit var eventsInformationUpdate: EventsInformation

    @BeforeEach
    fun setUp(){
        todoEvent = TodoEvent(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
        eventsInformationSave = EventsInformation(Events.SAVE,todoEvent)
        eventsInformationUpdate = EventsInformation(Events.UPDATE,todoEvent)
    }

    @Test
    fun `save`(){
        every { client.send(eventsInformationSave) } answers {Unit}
        val result = service.save(todoEvent)
        result shouldBe Unit
    }

    @Test
    fun `update`(){
        every { client.send(eventsInformationUpdate) } answers {Unit}
        val result = service.update(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),todoEvent)
        result shouldBe Unit
    }

    @Test
    fun `delete`(){
        every { client.send(any()) } answers {Unit}
        val result = service.delete(todoEvent.id!!)
        result shouldBe Unit
    }
}