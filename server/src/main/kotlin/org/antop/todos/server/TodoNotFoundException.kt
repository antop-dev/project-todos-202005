package org.antop.todos.server

class TodoNotFoundException(id: String) : RuntimeException("Could not find employee $id")
