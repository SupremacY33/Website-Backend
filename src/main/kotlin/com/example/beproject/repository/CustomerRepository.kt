package com.example.beproject.repository

import com.example.beproject.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface CustomerRepository: MongoRepository<CustomerEntity, String> {

    fun findCustomerEntityByCustomerEmail( customerEmail: String ): Optional<CustomerEntity>
}