package com.example.application.entities

import io.micronaut.core.annotation.Creator
import io.micronaut.serde.annotation.Serdeable
import org.bson.BsonType
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.codecs.pojo.annotations.BsonRepresentation

@Serdeable
data class Book @Creator @BsonCreator constructor(

    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    override val id: String? = null,

    @BsonProperty("code")
    var code: String,

    @BsonProperty("name")
    var name: String,

    @BsonProperty("launch_date")
    var launch_date: String,

    @BsonProperty("author")
    var author: Author

): IEntity<String>
