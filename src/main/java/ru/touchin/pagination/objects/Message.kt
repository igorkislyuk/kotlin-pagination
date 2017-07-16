package ru.touchin.pagination.objects

import org.hibernate.validator.constraints.NotBlank
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "messages", schema = "dev")
class Message(author: String, text: String) {

    @Id
    @Column(name = "id", unique = true)
    @NotBlank(message = "Field id cannot be empty")
    lateinit var identifier: String

    @Column(name = "text")
    @NotBlank(message = "Field text cannot be empty")
    var text: String = text

    @Column(name = "date")
    @NotBlank(message = "Field date cannot be empty")
    lateinit var date: Date

    @Column(name = "author")
    @NotBlank(message = "Field author cannot be empty")
    var authorName: String = author
}