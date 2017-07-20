package ru.touchin.pagination.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.NotBlank
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "messages", schema = "public")
class Message(author: String, text: String, date: Date) {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(36)")
    @Id
    lateinit var id: String

    @Column(name = "text")
    var text = text

    @Column(name = "date")
    var date = date

    @Column(name = "author")
    var authorName = author
}