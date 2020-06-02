package org.antop.todos.server

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component

@Component
class TodoModelAssembler : RepresentationModelAssembler<Todo, EntityModel<Todo>> {

    override fun toModel(entity: Todo): EntityModel<Todo> {
        return EntityModel.of(entity,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TodoController::class.java).one(entity.id!!)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TodoController::class.java).all()).withRel("todos")
        )
    }

}
