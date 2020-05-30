package org.antop.todos.server

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

/**
 * 할일
 *
 * @author Antop
 */
class Todo {
    /**
     * 아이디
     */
    @Id
    var id: String? = null

    /**
     * 할일 제목
     */
    lateinit var title: String

    /**
     * 등록 일시
     */
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    var created: LocalDateTime = LocalDateTime.now()

    /**
     * 완료 일시
     */
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    var completed: LocalDateTime? = null

    /**
     * 삭제 일시
     */
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    var deleted: LocalDateTime? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Todo

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Todo(id=$id, title='$title', created=$created, completed=$completed, deleted=$deleted)"
    }

}
