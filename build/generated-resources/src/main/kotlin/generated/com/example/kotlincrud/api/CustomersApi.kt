/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.7.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package generated.com.example.kotlincrud.api

import generated.com.example.kotlincrud.model.AdditionalCustomers
import generated.com.example.kotlincrud.model.CallToCompleteData
import generated.com.example.kotlincrud.model.CustomerAddition200Response
import generated.com.example.kotlincrud.model.CustomerLogin200Response
import generated.com.example.kotlincrud.model.CustomerUpdateIdPut200Response
import generated.com.example.kotlincrud.model.Customers
import generated.com.example.kotlincrud.model.DeleteCustomerIdDelete200Response
import generated.com.example.kotlincrud.model.InformationForLogin
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

import kotlin.collections.List
import kotlin.collections.Map

@Validated
interface CustomersApi {

    fun getDelegate(): CustomersApiDelegate = object: CustomersApiDelegate {}

    @Operation(
        tags = ["customers",],
        summary = "customer data",
        operationId = "completeCallToData",
        description = """getting all data of customer from database""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(array = ArraySchema(schema = Schema(implementation = CallToCompleteData::class)))]),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/completeDataCall"],
            produces = ["application/json"]
    )
    fun completeCallToData(): ResponseEntity<List<CallToCompleteData>> {
        return getDelegate().completeCallToData()
    }

    @Operation(
        tags = ["customers",],
        summary = "addition of customers in database",
        operationId = "customerAddition",
        description = """openapi for posting or adding customers""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CustomerAddition200Response::class))]),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/postingCustomers"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun customerAddition(@Parameter(description = "") @Valid @RequestBody(required = false) additionalCustomers: AdditionalCustomers?): ResponseEntity<CustomerAddition200Response> {
        return getDelegate().customerAddition(additionalCustomers)
    }

    @Operation(
        tags = ["customers",],
        summary = "string message",
        operationId = "customerGreeting",
        description = """string message to be displayed over ReactJS""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = Customers::class))]),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/greetings"],
            produces = ["application/json"]
    )
    fun customerGreeting(): ResponseEntity<Customers> {
        return getDelegate().customerGreeting()
    }

    @Operation(
        tags = ["customers",],
        summary = "logging the user in website",
        operationId = "customerLogin",
        description = """api for logging in user at frontend""",
        responses = [
            ApiResponse(responseCode = "200", description = "Ok", content = [Content(schema = Schema(implementation = CustomerLogin200Response::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/customer/login"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun customerLogin(@Parameter(description = "") @Valid @RequestBody(required = false) informationForLogin: InformationForLogin?): ResponseEntity<CustomerLogin200Response> {
        return getDelegate().customerLogin(informationForLogin)
    }

    @Operation(
        tags = ["customers",],
        summary = "updating customers previous recorded data and saving the new record",
        operationId = "customerUpdateIdPut",
        description = """updating customers saved data""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CustomerUpdateIdPut200Response::class))]),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "500", description = "Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.PUT],
            value = ["/customerUpdate/{id}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun customerUpdateIdPut(@Parameter(description = "", required = true) @PathVariable("id") id: kotlin.String,@Parameter(description = "") @Valid @RequestBody(required = false) additionalCustomers: AdditionalCustomers?): ResponseEntity<CustomerUpdateIdPut200Response> {
        return getDelegate().customerUpdateIdPut(id, additionalCustomers)
    }

    @Operation(
        tags = ["customers",],
        summary = "delete every inactive customers from the database records",
        operationId = "deleteCustomerIdDelete",
        description = """delete inactive customers from record""",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = DeleteCustomerIdDelete200Response::class))]),
            ApiResponse(responseCode = "400", description = "Bad Request"),
            ApiResponse(responseCode = "404", description = "Not Found"),
            ApiResponse(responseCode = "500", description = "Internal Server Error")
        ]
    )
    @RequestMapping(
            method = [RequestMethod.DELETE],
            value = ["/deleteCustomer/{id}"],
            produces = ["application/json"]
    )
    fun deleteCustomerIdDelete(@Parameter(description = "", required = true) @PathVariable("id") id: kotlin.String): ResponseEntity<DeleteCustomerIdDelete200Response> {
        return getDelegate().deleteCustomerIdDelete(id)
    }
}
