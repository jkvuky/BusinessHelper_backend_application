package com.business_helper.backend_application.controller

import com.business_helper.backend_application.dto.event.DailyEventListDTO
import com.business_helper.backend_application.dto.event.EventDTO
import com.business_helper.backend_application.service.EventService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/events")
class EventController(val service: EventService) {

    @GetMapping("/all")
    fun getEvents(): List<EventDTO> {
        return service.getEvents()
    }

    @GetMapping("/title")
    fun getEventByTitle(@RequestParam("event_name") eventName: String): EventDTO {
        return service.getEventByTitle(eventName)
    }

    @GetMapping("/daily_events")
    fun getDailyEvents(@RequestParam("date") date: String, @RequestParam("idUser") idUser: Int): List<DailyEventListDTO> {
        return service.getDailyEvents(date, idUser)
    }

    @PostMapping("/add",
        produces = ["application/json"],
        consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun addEvent(@RequestBody @Valid event: EventDTO): EventDTO {
        return service.addEvent(event)
    }

    @PutMapping("/update/{event_id}")
    fun updateEvent(
        @RequestBody events: EventDTO, @PathVariable("event_id") eventId: Int
    ) = service.updateEvent(events, eventId)

    @DeleteMapping("/delete/{event_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable("event_id") eventId: Int) = service.deleteEvent(eventId)
}