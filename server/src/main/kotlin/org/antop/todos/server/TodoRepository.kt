package org.antop.todos.server

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : MongoRepository<Todo, String> {

}
