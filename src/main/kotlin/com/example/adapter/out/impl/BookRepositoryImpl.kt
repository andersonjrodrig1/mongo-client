package com.example.adapter.out.impl

import com.example.adapter.config.MongoDatabase
import com.example.application.entities.Book
import com.example.ports.repository.BookRepository
import com.mongodb.client.model.Filters
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
    override fun save(entity: Book): Mono<Book> =
        withCollection {
            Mono.from(insertOne(entity)).map { entity }
        }

    override fun findAll(): Flux<Book> =
        withCollection {
            Flux.from(find())
        }

    override fun findById(id: String): Mono<Book> =
        withCollection {
            Mono.from(find(Filters.and(
                Filters.eq("_id", ObjectId(id))
            )))
        }

    override fun update(entity: Book): Mono<Book> =
        withCollection {
            replaceOne(Filters.eq("_id", entity.id), entity)
            Mono.just(entity)
        }

    override fun deleteById(id: String): Unit =
        withCollection {
            Mono.from(deleteOne(Filters.and(
                Filters.eq("_id", ObjectId(id))
            ))).subscribe()
        }

}