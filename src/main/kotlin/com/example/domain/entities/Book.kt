package com.example.domain.entities

import org.bson.types.ObjectId

data class Book(

    override val id: ObjectId? = null,
    var code: String,
    var name: String,
    var launch_date: String

): IEntity<ObjectId>
