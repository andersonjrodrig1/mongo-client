package com.example.ports.repository

import org.bson.types.ObjectId
import java.awt.print.Book

interface BookRepository: BaseRepository<Book, ObjectId> { }