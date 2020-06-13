package org.antop.todos.server

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import org.mongodb.morphia.annotations.Entity
import org.springframework.data.annotation.Id
import org.springframework.hateoas.server.core.Relation
import java.time.LocalDateTime

/**
 * 할일
 *
 * @author Antop
 */
@Entity
@Relation(collectionRelation = "todos")
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
     * 완료 여부
     */
    var done = false

    /**
     * 완료 일시
     */
    @JsonIgnore
    var doned: LocalDateTime? = null

    /**
     * 삭제 여부
     */
    @JsonIgnore
    var delete = false

    /**
     * 삭제 일시
     */
    @JsonIgnore
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
        return "Todo(id=$id, title='$title', created=$created, done=$done, doned=$doned, delete=$delete, deleted=$deleted)"
    }

}
