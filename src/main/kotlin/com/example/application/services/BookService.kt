package com.example.application.services

import com.example.application.entities.Book
import com.example.extension.execute
import com.example.extension.executeList
import com.example.extension.executeOptional
import com.example.extension.isExecute
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import java.util.Optional

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

    override fun findById(id: String): Optional<Book> = executeOptional {
        bookRepository.findById(id).blockOptional()
    }

    override fun update(book: Book): Book? = execute {
        bookRepository.update(book).block()
    }

    override fun deleteById(id: String): Boolean = isExecute {
        val entityOptional = findById(id)

        when {
            entityOptional.isEmpty -> false
            else -> {
                bookRepository.deleteById(id)
                true
            }
        }
    }

}