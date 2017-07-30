package ru.touchin.pagination.entity.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonValue
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "messages", schema = "public")
class Message {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(36)")
    @Id
    lateinit var id: String

    @Column(name = "text")
    lateinit var text: String

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssZ")
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var date: java.util.Date

    @Column(name = "author")
    lateinit var authorName: String
}