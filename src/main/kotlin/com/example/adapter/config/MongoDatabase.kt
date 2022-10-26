package com.example.adapter.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoDatabase
import io.micronaut.configuration.mongo.core.DefaultMongoConfiguration
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class MongoDatabase(
    private val mongoClient: MongoClient,
    private val defaultMongoConfig: DefaultMongoConfiguration
) {

    @Singleton
    fun getMongoDatabase(): MongoDatabase =
        mongoClient.getDatabase(defaultMongoConfig.connectionString.get().database)

}