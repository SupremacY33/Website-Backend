package com.example.beproject.service

import com.example.beproject.entity.CustomerEntity
import com.example.beproject.mapping.mapToCompleteCustomerData
import com.example.beproject.mapping.mapToCustomerEntity
import com.example.beproject.repository.CustomerRepository
import generated.com.example.kotlincrud.model.CallToCompleteData
import generated.com.example.kotlincrud.model.Customers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService @Autowired constructor(
    private val customerRepository: CustomerRepository
) {

    fun greetToReact(): Customers {
        return Customers(
            message = "Welcome To CyberMarket"
        )
    }

    fun createNewCustomer(
        name: String?,
        email: String?,
        password: String?,
        confirmPassword: String?
    ) {
        val customerCheck = email?.let {
            customerRepository.findCustomerEntityByCustomerEmail(it).isPresent
        }

        if (customerCheck == true) {
            throw IllegalStateException(
                "$email has an active account already!!!!"
            )
        } else {
            val gettingEntityMapping = mapToCustomerEntity(
                CustomerEntity(
                    null,
                    name,
                    email,
                    password,
                    confirmPassword
                )
            )

            println("Complete Customer Record Saved, Here's the detail: $gettingEntityMapping")

            customerRepository.save(
                gettingEntityMapping
            )
        }
    }

    fun savingNewCustomerRecord(
        id: String,
        customerName: String?,
        customerEmail: String?,
        customerPassword: String?,
        customerConfirmPassword: String?
    ) {
        val updatingCustomer = customerRepository.findById(id).orElseThrow {
            IllegalStateException("$id doesn't exits or it has been deleted")
        }

        customerName?.let { updatingCustomer.customerName = it }
        customerEmail?.let { updatingCustomer.customerEmail = it }
        customerPassword?.let { updatingCustomer.customerPassword = it }
        customerConfirmPassword?.let { updatingCustomer.customerConfirmPassword = it }

        println("Record For $id has been Updated Successfully, Here's the updated Record: $updatingCustomer")

        customerRepository.save(updatingCustomer)
    }

    fun deleteCustomerById(id: String) {
        try {
            if (!customerRepository.existsById(id)) {
                throw IllegalStateException("$id doesn't exist or it has been deleted previously")
            }
            customerRepository.deleteById(id)
        } catch (e: Exception) {
            throw IllegalStateException("Error Deleting ID: $id: ${e.message}", e)
        }
    }

    fun authenticate(
        email: String?,
        password: String?
    ): Boolean {
        if (email == null || password == null) {
            return false
        }

        val customerDetails = customerRepository.findCustomerEntityByCustomerEmail(email)

        return customerDetails.map {
            val isPassword = it.customerPassword == password
            if (isPassword) {
                println("Authentication Cleared, Matched Email: $email & Password: $password")
            }
            isPassword
        }.orElseGet {
            println("Authentication Failed, Incorrect $email Or $password")
            false
        }
    }

    fun callToDataService(): List<CallToCompleteData> {
        val dataCollectionFromDB = customerRepository.findAll().toList()

        return dataCollectionFromDB.map {
            mapToCompleteCustomerData(
                it
            )
        }
    }
}