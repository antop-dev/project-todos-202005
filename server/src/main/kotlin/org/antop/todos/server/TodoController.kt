package org.antop.todos.server

import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@CrossOrigin
@RestController
class TodoController(private val repository: TodoRepository, private val assembler: TodoModelAssembler) {

    @GetMapping("/todos")
    fun all(): CollectionModel<EntityModel<Todo>> {
        return CollectionModel.of(
            repository.findNotDeleted(PageRequest.of(0, 10)).map { assembler.toModel(it) },
            linkTo(methodOn(TodoController::class.java).all()).withSelfRel()
        )
    }

    @GetMapping("/todos/{id}")
    fun one(@PathVariable id: String): EntityModel<Todo> {
        val todo = repository.findById(id).orElseThrow { TodoNotFoundException(id) }
        return assembler.toModel(todo)
    }

    @PostMapping("/todos")
    fun new(@RequestBody todo: Todo): ResponseEntity<Any> {
        todo.apply { created = LocalDateTime.now() }
        val entity = assembler.toModel(repository.save(todo))
        return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entity)
    }

    @PutMapping("/todos/{id}")
    fun replace(@RequestBody todo: Todo, @PathVariable id: String): ResponseEntity<Any> {
        val updatedTodo = repository.findById(id).map {
            it.title = todo.title
            it.done = todo.done
            if (it.done) it.doned = LocalDateTime.now()
            repository.save(it)
        }.orElseGet {
            todo.created = LocalDateTime.now()
            repository.save(todo)
        }

        val entity = assembler.toModel(updatedTodo)
        return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entity)
    }

    @DeleteMapping("/todos/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Any> {
        repository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
