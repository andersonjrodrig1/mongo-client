package com.example.adapter.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoDatabase
import io.micronaut.context.annotation.Factory
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Factory
class MongoDatabase(
    @Inject private val mongoClient: MongoClient
) {

    @Singleton
    fun getMongoDatabase(): MongoDatabase = mongoClient.getDatabase("example")

}