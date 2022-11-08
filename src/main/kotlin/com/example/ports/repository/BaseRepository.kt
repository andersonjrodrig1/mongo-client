package com.example.ports.repository

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BaseRepository<T, S> {

    fun save(entity: T): Mono<T>

    fun findAll(): Flux<T>

    fun findById(id: S): Mono<T>

    fun update(entity: T): Mono<T>

    fun deleteById(id: S)

}