package com.example.application.entities

import io.micronaut.core.annotation.Creator
import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

@Serdeable
data class Author @Creator @BsonCreator constructor(

    @BsonProperty("code")
    var code: String,

    @BsonProperty("name")
    var name: String

)
