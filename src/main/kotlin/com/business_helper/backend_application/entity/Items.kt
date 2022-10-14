package com.business_helper.backend_application.entity

import javax.persistence.*

@Entity
@Table(name = "ITEMS")
data class Items(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String,
    @OneToMany(mappedBy = "items", cascade = [CascadeType.ALL], orphanRemoval = true)
    val event: List<Event> = mutableListOf()
)
