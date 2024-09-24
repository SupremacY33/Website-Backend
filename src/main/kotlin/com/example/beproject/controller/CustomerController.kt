package com.example.beproject.controller

import com.example.beproject.service.CustomerService
import generated.com.example.kotlincrud.api.CustomersApi
import generated.com.example.kotlincrud.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired constructor(
    private val customerService: CustomerService
): CustomersApi {

    override fun customerGreeting(): ResponseEntity<Customers> {
        val resultingCustomer = customerService.greetToReact()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(resultingCustomer)
    }

    override fun customerAddition(
        additionalCustomers: AdditionalCustomers?
    ): ResponseEntity<CustomerAddition200Response> {

        if (additionalCustomers != null) {
            customerService.createNewCustomer(
                additionalCustomers.name,
                additionalCustomers.email,
                additionalCustomers.password,
                additionalCustomers.confirmPassword
            )
        }

        val responseBody = CustomerAddition200Response(
            message = "Record was created successfully"
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(responseBody)
    }

    override fun customerUpdateIdPut(
        id: String,
        additionalCustomers: AdditionalCustomers?
    ): ResponseEntity<CustomerUpdateIdPut200Response> {

        customerService.savingNewCustomerRecord(
            id,
            additionalCustomers?.name,
            additionalCustomers?.email,
            additionalCustomers?.password,
            additionalCustomers?.confirmPassword
        )

        val updateResponseBody = CustomerUpdateIdPut200Response(
            updateMessage = "Saved Record Updated Successfully"
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(updateResponseBody)
    }

    override fun deleteCustomerIdDelete(
        id: String
    ): ResponseEntity<DeleteCustomerIdDelete200Response> {
        customerService.deleteCustomerById(id)

        val deleteResponseBody = DeleteCustomerIdDelete200Response(
            deleteMessage = "Record Has Been Deleted Successfully"
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(deleteResponseBody)
    }

    override fun customerLogin(
        informationForLogin: InformationForLogin?
    ): ResponseEntity<CustomerLogin200Response> {
        if (informationForLogin != null) {
            val isAuthenticated = customerService.authenticate(
                informationForLogin.email,
                informationForLogin.password
            )

            return if (isAuthenticated) {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                        CustomerLogin200Response(
                            loginMessage = "Authentication Passed, Correct ${informationForLogin.email} and ${informationForLogin.password}"
                        )
                    )
            } else {
                println("Unauthorized User, Incorrect Email: ${informationForLogin.email} or Password: ${informationForLogin.password}")
                ResponseEntity(HttpStatus.UNAUTHORIZED)
            }
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    override fun completeCallToData(): ResponseEntity<List<CallToCompleteData>> {
        val dataCollection = customerService.callToDataService()

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(dataCollection)
    }
}