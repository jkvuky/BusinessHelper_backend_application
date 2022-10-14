package com.business_helper.backend_application.entity

import javax.persistence.*

@Entity
@Table(name = "EVENTS")
data class Event(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String,
    var description: String,
    var date: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEMS_ID", nullable = true)
    var items: Items?
)