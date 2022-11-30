package com.example.application.services

import com.example.application.entities.Book
import com.example.extension.execute
import com.example.extension.executeList
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import jakarta.inject.Singleton
import org.bson.types.ObjectId

@Singleton
class BookService(
    private val bookRepository: BookRepository
): BookUseCases {

    override fun save(book: Book): Book? = execute {
        bookRepository.save(book).block()
    }

    override fun findAll(): MutableList<Book> = executeList {
        bookRepository.findAll()
            .toIterable()
            .toMutableList()
    }

    override fun findById(id: String): Book? = execute {
        bookRepository.findById(id).block()
    }

    override fun update(book: Book): Book {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ObjectId): Boolean {
        TODO("Not yet implemented")
    }

}