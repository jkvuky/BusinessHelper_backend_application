package com.business_helper.backend_application.dto

import com.business_helper.backend_application.entity.Items
import javax.validation.constraints.NotBlank

data class EventDTO(

    val id : Int?,
    @get: NotBlank(message = "eventDto.name must not be blank")
    val name : String,
    val description : String,
    val date : String,
    val items: Items?
)