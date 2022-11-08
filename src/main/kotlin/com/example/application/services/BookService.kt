package com.example.application.services

import com.example.application.entities.Book
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory

@Singleton
class BookService(
    private val bookRepository: BookRepository
): BookUseCases {

    private val logger = LoggerFactory.getLogger("BookServiceKt")

    override fun save(book: Book): Book? = runCatching {
        bookRepository.save(book).block()
    }.onSuccess {
        logger.info("Salvo com sucesso. $it")
    }.onFailure {
        logger.error("Falha ao salvar o livro. ${it.message}")
        throw it
    }.getOrThrow()

    override fun findAll(): MutableList<Book> = runCatching {
        bookRepository.findAll()
            .toIterable()
            .toMutableList()
    }.onSuccess {
        logger.info("Sucesso ao buscar dados. $it")
    }.onFailure {
        logger.error("Falha ao buscar livros. ${it.message}")
        throw it
    }.getOrThrow()

    override fun findById(id: String): Book? = runCatching {
        bookRepository.findById(id).block()
    }.onSuccess {
        logger.info("Sucesso ao buscar livro. $it")
    }.onFailure {
        logger.error("Falha ao buscar o livro. ${it.message}")
    }.getOrThrow()

    override fun update(book: Book): Book {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ObjectId): Boolean {
        TODO("Not yet implemented")
    }

}