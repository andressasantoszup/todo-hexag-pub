package br.com.andressa.entrypoint

import br.com.andressa.core.model.Todo
import br.com.andressa.core.ports.TodoServicePort
import br.com.andressa.entrypoint.controller.TodoController
import br.com.andressa.entrypoint.model.TodoRequest
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class TodoControllerTest: AnnotationSpec() {

    val port = mockk<TodoServicePort>()
    val controller = TodoController(port)

    lateinit var todoRequest: TodoRequest
    lateinit var todo: Todo

    @BeforeEach
    fun setUp(){
        todoRequest = TodoRequest(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
        todo = Todo(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
    }

    @Test
    fun `recebendo requisição do client e salvando`(){
        every { port.save(todo) } answers { Unit }
        val result = controller.save(todoRequest)
        result shouldBe Unit
    }

    @Test
    fun `recebendo requisição do cliente e atualizando`(){
        every { port.update(any(),todo) } answers { Unit }
        val result = controller.update(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),todoRequest)
        result shouldBe Unit
    }

    @Test
    fun `recebendo requisição do cliente e deletando`(){
        every { port.delete(any()) } answers {Unit}
        val result = controller.delete(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"))
        result shouldBe Unit
    }
}