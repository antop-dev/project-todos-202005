package org.antop.todos.server

import org.antop.todos.server.QTodo.todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport

class TodoRepositoryImpl(mongoTemplate: MongoTemplate) :
    QuerydslRepositorySupport(mongoTemplate), TodoRepositoryCustom {

    override fun findNotDeleted(pageable: Pageable): Page<Todo> {
        val results =
            from(todo).where(todo.delete.isFalse).offset(pageable.offset).limit(pageable.pageSize.toLong())
                .orderBy(todo.created.desc()).fetchResults()
        return PageImpl(results.results, pageable, results.total)

    }

}
