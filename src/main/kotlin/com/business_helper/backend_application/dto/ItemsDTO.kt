package com.business_helper.backend_application.dto

import javax.validation.constraints.NotBlank

data class ItemsDTO(
    val id: Int?,
    @get: NotBlank(message = "itemsDto.name must not be blank")
    var name: String,
)
