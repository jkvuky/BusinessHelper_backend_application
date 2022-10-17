package com.business_helper.backend_application.entity

import javax.persistence.*

@Entity
@Table(name = "EVENTS")
data class Event(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    @Column(name = "NAME", nullable = false)
    var name: String,
    @Column(name = "DESCRIPTION", nullable = false)
    var description: String,
    @Column(name = "DATE", nullable = false)
    var date: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEMS_ID")
    var items: Items?
)