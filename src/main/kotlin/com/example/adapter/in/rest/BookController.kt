package com.example.adapter.`in`.rest

import com.example.application.entities.Book
import com.example.ports.usecases.BookUseCases
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/book")
open class BookController(
    private val bookUseCases: BookUseCases
) {

    @Post
    open fun save(entity: Book): MutableHttpResponse<*> = HttpResponse.ok(bookUseCases.save(entity))

    @Get
    open fun findAll(): MutableHttpResponse<*> = HttpResponse.ok(bookUseCases.findAll())

    @Get("{id}")
    open fun findById(id: String): MutableHttpResponse<*> = HttpResponse.ok(bookUseCases.findById(id))

    open fun update(entity: Book) {}

    open fun delete(id: String) {}

}