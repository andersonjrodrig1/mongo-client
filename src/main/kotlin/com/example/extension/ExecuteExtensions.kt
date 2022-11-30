package com.example.extension

import com.example.application.entities.IEntity
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("ExecuteExtensionsKt")

fun <E: IEntity<*>> execute(block: () -> E): E =
    runCatching { block() }.onSuccess {
        logger.info("Executado com sucesso. $it")
    }.onFailure {
        logger.error("Falha durante a execução. ${it.message}")
        throw it
    }.getOrThrow()

fun <E: IEntity<*>> executeList(block: () -> MutableList<E>): MutableList<E> =
    runCatching { block() }.onSuccess {
        logger.info("Executado com sucesso. $it")
    }.onFailure {
        logger.error("Falha durante a execução. ${it.message}")
        throw it
    }.getOrThrow()