package com.example.ports.repository

interface BaseRepository<T, S> {

    fun save(entity: T): T

    fun findAll(): MutableList<T>

    fun findById(id: S): T

    fun update(entity: T): T

    fun deleteById(id: S)

}