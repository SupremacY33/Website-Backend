package generated.com.example.kotlincrud.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param deleteMessage 
 */
data class DeleteCustomerIdDelete200Response(

    @Schema(example = "null", description = "")
    @get:JsonProperty("deleteMessage") var deleteMessage: kotlin.String? = null
) {

}

