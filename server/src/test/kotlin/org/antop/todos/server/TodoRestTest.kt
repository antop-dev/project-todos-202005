package org.antop.todos.server

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class TodoRestTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun post() {
        val todo = Todo().apply {
            title = "todo title"
        }

        mockMvc.post("/todos") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(todo)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated }
            content { contentType(MediaType.APPLICATION_JSON) }
        }.andDo { print() }
    }

}
