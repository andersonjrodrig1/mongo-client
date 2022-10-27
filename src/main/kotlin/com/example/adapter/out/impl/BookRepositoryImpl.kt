package com.example.adapter.out.impl

import com.example.adapter.config.MongoDatabase
import com.example.application.entities.Book
import com.example.ports.repository.BookRepository
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Singleton
class BookRepositoryImpl(
    mongoDatabase: MongoDatabase
): BookRepository, BaseRepositoryImpl<Book>(
    mongoDatabase = mongoDatabase,
    collectionName = "book",
    clazz = Book::class.java
) {

    override fun save(entity: Book): Unit =
        withCollection {
            Mono.from(
                insertOne(entity)
            ).subscribe()
        }

    override fun findAll(): Flux<Book> =
        withCollection {
            Flux.from(find())
        }

    override fun findById(id: ObjectId): Mono<Book> {
        TODO("Not yet implemented")
    }

    override fun update(entity: Book): Mono<Book> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ObjectId) {
        TODO("Not yet implemented")
    }

}