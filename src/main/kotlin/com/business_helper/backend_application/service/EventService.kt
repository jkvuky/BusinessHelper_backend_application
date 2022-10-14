package com.business_helper.backend_application.service

import com.business_helper.backend_application.dto.EventDTO
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
                    name = it.name,
                    description = it.description,
                    date = it.date,
                    items = it.items
                )
            }
    }

    fun addEvent(event: EventDTO): EventDTO {
        val eventEntity = event.let {
            Event(
                id = null,
                name = it.name,
                description = it.description,
                date = it.date,
                items = it.items
            )
        }

        repository.save(eventEntity)

        return eventEntity.let {
            EventDTO(
                id = it.id,
                name = it.name,
                description = it.description,
                date = it.date,
                items = it.items
            )
        }
    }

    fun updateEvent(events: EventDTO, eventId: Int): EventDTO {

        val existingEvent = repository.findById(eventId)

         return if (existingEvent.isPresent) {
            existingEvent.get()
                .let {
                    it.name = events.name
                    it.description = events.description
                    it.date = events.date
                    EventDTO(
                        id = it.id,
                        name = it.name,
                        description = it.description,
                        date = it.date,
                        items = it.items
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
                name = it.name,
                description = it.description,
                date = it.date,
                items = it.items
            )
        }
    }

}