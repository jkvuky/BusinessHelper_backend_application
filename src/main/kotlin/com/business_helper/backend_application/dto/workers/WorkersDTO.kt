package com.business_helper.backend_application.dto.workers

import com.business_helper.backend_application.commons.data.TypeWorker

data class WorkersDTO(
    val id: Int?,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val phone: String,
    val role: TypeWorker,
)
