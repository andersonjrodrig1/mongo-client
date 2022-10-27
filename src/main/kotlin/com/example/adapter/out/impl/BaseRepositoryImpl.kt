package com.example.adapter.out.impl

import com.example.adapter.config.MongoDatabase
import com.mongodb.reactivestreams.client.MongoCollection

abstract class BaseRepositoryImpl<T>(
    private val mongoDatabase: MongoDatabase,
    private val collectionName: String,
    private val clazz: Class<T>
) {

    protected fun <R> withCollection(fn: MongoCollection<T>.() -> R): R =
        mongoDatabase
            .getMongoDatabase()
            .getCollection(collectionName, clazz)
            .let(fn)

}