package ru.touchin.pagination.entity.models

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.NotBlank
import java.sql.Date
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

    @Column(name = "date")
    lateinit var date: Date

    @Column(name = "author")
    lateinit var authorName: String
}