package com.example.ports.repository

import com.example.application.entities.Book
import org.bson.types.ObjectId

interface BookRepository: BaseRepository<Book, ObjectId> { }