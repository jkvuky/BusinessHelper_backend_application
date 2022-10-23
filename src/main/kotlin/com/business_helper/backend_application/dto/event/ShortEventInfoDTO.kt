package com.business_helper.backend_application.dto.event

import com.business_helper.backend_application.commons.data.StatusEvent
import com.business_helper.backend_application.commons.data.TypeEvent
import com.business_helper.backend_application.entity.Clients
import com.business_helper.backend_application.entity.Workers
import java.time.LocalDateTime

data class ShortEventInfoDTO(
    val id: Int?,
    val name: Clients,
    val workers: List<Workers>?,
    val status: StatusEvent,
    val dateStart: LocalDateTime?,
    val eventType: TypeEvent
)