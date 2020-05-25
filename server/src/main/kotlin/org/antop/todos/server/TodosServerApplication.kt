package org.antop.todos.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodosServerApplication

fun main(args: Array<String>) {
    runApplication<TodosServerApplication>(*args)
}
