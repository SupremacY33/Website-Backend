package com.example.beproject.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "kotlinBackEnd")
data class CustomerEntity(
    @Id
    val id: String?= null,

    var customerName: String?= null,

    var customerEmail: String?= null,

    var customerPassword: String?= null,

    var customerConfirmPassword: String?= null
)
