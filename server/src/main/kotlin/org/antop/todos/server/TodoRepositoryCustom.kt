package org.antop.todos.server

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TodoRepositoryCustom {

    fun findNotDeleted(pageable: Pageable): Page<Todo>

}
