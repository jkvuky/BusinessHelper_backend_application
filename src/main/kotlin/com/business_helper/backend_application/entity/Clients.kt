package com.business_helper.backend_application.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "CLIENTS")
data class Clients(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,

    @Column(name = "name", nullable = true)
    var name: String?,

    @Column(name = "address", nullable = true)
    var address: String?,

    @Column(name = "address_latLng", nullable = true)
    var addressLatLng: Pair<Double, Double>?,

    @Column(name = "phone", nullable = true)
    var phone: String?,

    @Column(name = "email", nullable = true)
    var email: String?,

    @Column(name = "nip", nullable = true)
    var nip: String?,

    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    var modifier: LocalDateTime = LocalDateTime.now()
    ) {
    constructor() : this(
        null,
        "",
        "",
        Pair(0.0, 0.0),
        "",
        "",
        "",
    )
}


