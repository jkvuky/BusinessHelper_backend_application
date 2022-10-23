package com.business_helper.backend_application.service

import com.business_helper.backend_application.dto.event.DailyEventListDTO
import com.business_helper.backend_application.dto.event.EventDTO
import com.business_helper.backend_application.dto.event.ShortEventInfoDTO
import com.business_helper.backend_application.entity.Event
import com.business_helper.backend_application.exception.EventNotFoundException
import com.business_helper.backend_application.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(val repository: EventRepository) {

    fun getEvents(): List<EventDTO> {

        return repository.findAll()
            .map {
                EventDTO(
                    id = it.id,
                    name = it.clients,
                    description = it.description,
                    dateAdd = it.dateAdd,
                    dateStart = it.dateStart,
                    dateEnd = it.dateEnd,
                    image = it.image,
                    price = it.price,
                    time = it.time,
                    eventStatus = it.eventStatus,
                    eventType = it.eventType,
                    workers = it.workers
                )
            }
    }

    fun addEvent(event: EventDTO): EventDTO {
        val eventEntity = event.let {
            Event(
                id = it.id,
                clients = it.name,
                description = it.description,
                dateAdd = it.dateAdd,
                dateStart = it.dateStart,
                dateEnd = it.dateEnd,
                image = it.image,
                price = it.price,
                time = it.time,
                eventStatus = it.eventStatus,
                eventType = it.eventType,
                workers = it.workers
            )
        }

        repository.save(eventEntity)

        return eventEntity.let {
            EventDTO(
                id = it.id,
                name = it.clients,
                description = it.description,
                dateAdd = it.dateAdd,
                dateStart = it.dateStart,
                dateEnd = it.dateEnd,
                image = it.image,
                price = it.price,
                time = it.time,
                eventStatus = it.eventStatus,
                eventType = it.eventType,
                workers = it.workers
            )
        }
    }

    fun updateEvent(events: EventDTO, eventId: Int): EventDTO {

        val existingEvent = repository.findById(eventId)

        return if (existingEvent.isPresent) {
            existingEvent.get()
                .let {
                    it.clients = events.name
                    it.description = events.description
                    it.dateAdd = events.dateAdd
                    EventDTO(
                        id = it.id,
                        name = it.clients,
                        description = it.description,
                        dateAdd = it.dateAdd,
                        dateStart = it.dateStart,
                        dateEnd = it.dateEnd,
                        image = it.image,
                        price = it.price,
                        time = it.time,
                        eventStatus = it.eventStatus,
                        eventType = it.eventType,
                        workers = it.workers
                    )
                }
        } else {
            throw EventNotFoundException("Event with id $eventId not found")
        }
    }

    fun deleteEvent(eventId: Int) {

        val existingEvent = repository.findById(eventId)

        if (existingEvent.isPresent) {
            existingEvent.get()
                .let {
                    repository.deleteById(eventId)
                }
        } else {
            throw EventNotFoundException("Event with id $eventId not found")
        }

    }

    fun getEventByTitle(eventName: String): EventDTO {

        val event = eventName.let {
            repository.findByNameContaining(it)
        }
        return event.let {
            EventDTO(
                id = it.id,
                name = it.clients,
                description = it.description,
                dateAdd = it.dateAdd,
                dateStart = it.dateStart,
                dateEnd = it.dateEnd,
                image = it.image,
                price = it.price,
                time = it.time,
                eventStatus = it.eventStatus,
                eventType = it.eventType,
                workers = it.workers
            )
        }
    }

    fun getDailyEvents(date: String, idUser: Int): List<DailyEventListDTO> {

        val event = Pair(date, idUser).let {
            repository.findEventsByDateStartAndWorker(it.first, it.second)
        }
        return event.map {
            DailyEventListDTO(
                events = listOf(
                    ShortEventInfoDTO(
                        id = it.id,
                        name = it.clients,
                        workers = it.workers,
                        status = it.eventStatus,
                        dateStart = it.dateStart,
                        eventType = it.eventType
                    )
                )
            )
        }
    }

}