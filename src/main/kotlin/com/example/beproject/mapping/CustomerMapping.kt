package com.example.beproject.mapping

import com.example.beproject.entity.CustomerEntity
import generated.com.example.kotlincrud.model.CallToCompleteData

fun mapToCustomerEntity(
    customerEntity: CustomerEntity
): CustomerEntity {
    return CustomerEntity(
        customerName = customerEntity.customerName,
        customerEmail = customerEntity.customerEmail,
        customerPassword = customerEntity.customerPassword,
        customerConfirmPassword = customerEntity.customerConfirmPassword
    )
}

fun mapToCompleteCustomerData(
    customerEntities: CustomerEntity
): CallToCompleteData {
    return CallToCompleteData(
        id = customerEntities.id,
        name = customerEntities.customerName,
        email = customerEntities.customerEmail,
        password = customerEntities.customerPassword,
        confirmPassword = customerEntities.customerConfirmPassword
    )
}