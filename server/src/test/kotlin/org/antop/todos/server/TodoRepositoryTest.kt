package org.antop.todos.server

import com.github.javafaker.Faker
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.notNullValue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest

@DataMongoTest
class TodoRepositoryTest {
    @Autowired
    lateinit var repository: TodoRepository
    val faker = Faker()

    @Test
    fun save() {
        val todo = Todo().apply {
            title = faker.book().title()
        }
        // save
        repository.save(todo)

        println(todo)
        assertThat(todo.id, notNullValue())
    }

    @Test
    fun findAll() {
        val todo1 = Todo().apply { title = faker.book().title() }
        val todo2 = Todo().apply {
            title = "second todo"
        }
        // save
        repository.saveAll(listOf(todo1, todo2))

        val list = repository.findAll()
        assertThat(list, hasSize(2))
        for (todo in list) {
            println(todo)
        }
    }

}
