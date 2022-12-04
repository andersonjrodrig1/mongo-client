package com.example.ports.usecases

import com.example.application.entities.Book
import org.bson.types.ObjectId
import java.util.*

interface BookUseCases {

    fun save(book: Book): Book?

    fun findAll(): MutableList<Book>

    fun findById(id: String): Optional<Book>

    fun update(book: Book): Book?

    fun deleteById(id: String): Boolean

}