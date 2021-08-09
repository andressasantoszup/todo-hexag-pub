package br.com.andressa.core

import br.com.andressa.core.model.Todo
import br.com.andressa.core.service.TodoServiceImpl
import br.com.andressa.infrastructure.model.TodoEvent
import br.com.andressa.infrastructure.service.TodoServiceInfra
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class TodoServiceImplTest: AnnotationSpec() {

    val port = mockk<TodoServiceInfra>()
    val core = TodoServiceImpl(port)

    lateinit var todoEvent: TodoEvent
    lateinit var todo: Todo


    @BeforeEach
    fun setUp(){
        todoEvent = TodoEvent((UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003")),"segunda","correr",false)
        todo = Todo((UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003")),"segunda","correr",false)
    }

    @Test
    fun `save`(){
        every { port.save(todoEvent) } answers {Unit}
        val result = core.save(todo)
        result shouldBe Unit
    }

    @Test
    fun `update`(){
        every { port.update(any(),todoEvent) } answers {Unit}
        val result = core.update(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),todo)
        result shouldBe Unit
    }

    @Test
    fun `delete`(){
        every { port.delete(any()) } answers {Unit}
        val result = core.delete(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"))
        result shouldBe Unit
    }
}