package com.example.application.services

import com.example.application.entities.Book
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import jakarta.inject.Singleton
import org.bson.types.ObjectId

@Singleton
class BookService(
    private val bookRepository: BookRepository
): BookUseCases {

    override fun save(book: Book): Book {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Book> {

        val books = bookRepository.findAll()
            .toIterable()
            .toMutableList()

        return books
    }

    override fun findById(id: ObjectId): Book {
        TODO("Not yet implemented")
    }

    override fun update(book: Book): Book {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ObjectId): Boolean {
        TODO("Not yet implemented")
    }

}