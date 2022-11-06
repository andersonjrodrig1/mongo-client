package com.example.ports.repository

import com.example.application.entities.Book

interface BookRepository: BaseRepository<Book, String> { }