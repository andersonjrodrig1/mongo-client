package io.kotest.provided

import com.example.containers.MongoDbContainerTest
import io.kotest.core.config.AbstractProjectConfig
import io.micronaut.test.extensions.kotest.MicronautKotestExtension

object ProjectConfig : AbstractProjectConfig() {
    override fun listeners() = listOf(MicronautKotestExtension)
    override fun extensions() = listOf(MicronautKotestExtension)

    override fun beforeAll() {
        super.beforeAll()
        MongoDbContainerTest.start()
    }

    override fun afterAll() {
        super.afterAll()
        MongoDbContainerTest.stop()
    }
}
