package com.business_helper.backend_application.dto.event

import javax.validation.constraints.NotBlank

data class ItemsDTO(
    val id: Int?,
    @get: NotBlank(message = "itemsDto.name must not be blank")
    var name: String,
)
