package org.antop.todos.server

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

internal class TodoTest {

    @Test
    fun `인스턴스 생성`() {
        val title = "나의 할일"
        val todo = Todo().apply {
            this.title = title
        }

        assertThat(todo.title, `is`(title))
    }
}
