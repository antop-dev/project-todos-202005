package org.antop.todos.server

import org.springframework.data.mongodb.repository.MongoRepository

interface TodoRepository : MongoRepository<Todo, String>, TodoRepositoryCustom {

}
