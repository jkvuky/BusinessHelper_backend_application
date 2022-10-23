package com.business_helper.backend_application.repository

import com.business_helper.backend_application.entity.Event
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface EventRepository : CrudRepository<Event, Int> {

    fun findByNameContaining(name: String): Event

    @Query("SELECT * FROM EVENTS where name LIKE %?1%", nativeQuery = true)
    fun findEventByName(name: String): Event

    @Query("SELECT * FROM EVENTS where dateStart LIKE = %?1% AND worker LIKE %?2%", nativeQuery = true)
    fun findEventsByDateStartAndWorker(date: String, idUser: Int): List<Event>
}
