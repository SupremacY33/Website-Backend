package generated.com.example.kotlincrud.api

import generated.com.example.kotlincrud.model.AdditionalCustomers
import generated.com.example.kotlincrud.model.CallToCompleteData
import generated.com.example.kotlincrud.model.CustomerAddition200Response
import generated.com.example.kotlincrud.model.CustomerLogin200Response
import generated.com.example.kotlincrud.model.CustomerUpdateIdPut200Response
import generated.com.example.kotlincrud.model.Customers
import generated.com.example.kotlincrud.model.DeleteCustomerIdDelete200Response
import generated.com.example.kotlincrud.model.InformationForLogin
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.core.io.Resource

import java.util.Optional

/**
 * A delegate to be called by the {@link CustomersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"], comments = "Generator version: 7.7.0")
interface CustomersApiDelegate {

    fun getRequest(): Optional<NativeWebRequest> = Optional.empty()

    /**
     * @see CustomersApi#completeCallToData
     */
    fun completeCallToData(): ResponseEntity<List<CallToCompleteData>> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "[ {  \"password\" : \"password\",  \"name\" : \"name\",  \"confirmPassword\" : \"confirmPassword\",  \"id\" : \"id\",  \"email\" : \"email\"}, {  \"password\" : \"password\",  \"name\" : \"name\",  \"confirmPassword\" : \"confirmPassword\",  \"id\" : \"id\",  \"email\" : \"email\"} ]")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see CustomersApi#customerAddition
     */
    fun customerAddition(additionalCustomers: AdditionalCustomers?): ResponseEntity<CustomerAddition200Response> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"Record Created Successfully\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see CustomersApi#customerGreeting
     */
    fun customerGreeting(): ResponseEntity<Customers> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"message\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see CustomersApi#customerLogin
     */
    fun customerLogin(informationForLogin: InformationForLogin?): ResponseEntity<CustomerLogin200Response> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"loginMessage\" : \"loginMessage\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see CustomersApi#customerUpdateIdPut
     */
    fun customerUpdateIdPut(id: kotlin.String,
        additionalCustomers: AdditionalCustomers?): ResponseEntity<CustomerUpdateIdPut200Response> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"updateMessage\" : \"updateMessage\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see CustomersApi#deleteCustomerIdDelete
     */
    fun deleteCustomerIdDelete(id: kotlin.String): ResponseEntity<DeleteCustomerIdDelete200Response> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"deleteMessage\" : \"deleteMessage\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
