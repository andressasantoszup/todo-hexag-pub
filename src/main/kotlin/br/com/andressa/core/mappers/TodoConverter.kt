package br.com.andressa.core.mappers

import br.com.andressa.core.model.Todo
import br.com.andressa.entrypoint.model.TodoRequest
import br.com.andressa.infrastructure.model.TodoEvent

class TodoConverter {
    companion object{
        fun todoToTodoEvent (todo: Todo) =
            TodoEvent(todo.id,todo.date,todo.description,todo.done)


        fun todoRequestToTodo(todoRequest: TodoRequest) =
            Todo(todoRequest.id,todoRequest.date,todoRequest.description,todoRequest.done)
    }
}