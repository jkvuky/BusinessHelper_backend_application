package com.business_helper.backend_application.dto.event

import com.business_helper.backend_application.commons.data.StatusEvent
import com.business_helper.backend_application.commons.data.TypeEvent
import com.business_helper.backend_application.entity.Clients
import com.business_helper.backend_application.entity.Image
import com.business_helper.backend_application.entity.Workers
import java.time.LocalDateTime

data class EventDTO(

    val id : Int?,
    val name: Clients,
    val description: String,
    val dateAdd: LocalDateTime,
    val dateStart: LocalDateTime?,
    val dateEnd: LocalDateTime?,
    val image: List<Image>?,
    val price: Double?,
    val time: Int?,
    val eventStatus: StatusEvent,
    val eventType: TypeEvent,
    val workers: List<Workers>?
)