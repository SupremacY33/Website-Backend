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
 * @param id 
 * @param name 
 * @param email 
 * @param password 
 * @param confirmPassword 
 */
data class CallToCompleteData(

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") var id: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") var name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("email") var email: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("password") var password: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("confirmPassword") var confirmPassword: kotlin.String? = null
) {

}

