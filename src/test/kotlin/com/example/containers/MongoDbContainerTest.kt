package com.example.containers

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.junit.jupiter.api.TestInstance
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoDbContainerTest {

    companion object {

        private lateinit var client: MongoClient
        private lateinit var mongoDb: MongoDBContainer

        fun start() {
            mongoDb = MongoDBContainer(
                DockerImageName
                    .parse("mongo:latest")
                    .asCompatibleSubstituteFor("mongo")
                )
                .withCommand("–auth", "–replSet", "docker-rs")
                .withEnv("MONGO_INITDB_DATABASE", "test")
                .withEnv("MONGO_INITDB_ROOT_USERNAME", "root")
                .withEnv("MONGO_INITDB_ROOT_PASSWORD", "root")
                .withExposedPorts(27017)

            mongoDb.setWaitStrategy(
                Wait.defaultWaitStrategy()
                    .withStartupTimeout(Duration.ofSeconds(60)))

            mongoDb.start()

            client = MongoClients.create(mongoDb.replicaSetUrl)
        }

        fun stop() = mongoDb.stop()

    }

}