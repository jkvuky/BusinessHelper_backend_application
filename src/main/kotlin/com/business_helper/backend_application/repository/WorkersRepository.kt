package com.business_helper.backend_application.repository

import com.business_helper.backend_application.dto.workers.WorkersDTO
import com.business_helper.backend_application.entity.Event
import com.business_helper.backend_application.entity.Workers
import org.springframework.data.repository.CrudRepository

interface WorkersRepository: CrudRepository<Workers, Int> {
    fun findByName(workerName: String): WorkersDTO

}