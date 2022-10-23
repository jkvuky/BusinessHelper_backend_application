package com.business_helper.backend_application.entity

import com.business_helper.backend_application.commons.data.StatusEvent
import com.business_helper.backend_application.commons.data.TypeEvent
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "EVENTS")
data class Event(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Column(name = "client", nullable = false)
    var clients: Clients,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "date_add", nullable = false)
    var dateAdd: LocalDateTime,

    @Column(name = "date_start", nullable = false)
    var dateStart: LocalDateTime?,

    @Column(name = "date_end", nullable = false)
    var dateEnd: LocalDateTime?,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEMS_ID")
    @Column(name = "image", nullable = true)
     var image: List<Image>?,

    @Column(name = "price", nullable = false)
    var price: Double?,

    @Column(name = "time", nullable = false)
    var time: Int?,

    @Column(name = "event_status", nullable = false)
    @Enumerated var eventStatus: StatusEvent,

    @Column(name = "event_type", nullable = false)
    @Enumerated var eventType: TypeEvent,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "WORKER_ID")
    @Column(name = "worker", nullable = false)
    var workers: List<Workers>?,

    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var modifier: LocalDateTime = LocalDateTime.now()
    ) {
    constructor() : this(
        null,
        Clients(),
        "",
        LocalDateTime.now(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        listOf(),
        0.0,
        0,
        StatusEvent.NEW,
        TypeEvent.SERVICE,
        listOf()
    )
}