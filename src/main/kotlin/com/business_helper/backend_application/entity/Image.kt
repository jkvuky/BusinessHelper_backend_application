package com.business_helper.backend_application.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*


@Table(name = "IMAGES")
@Entity
data class Image(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,

    @Column(name = "image", nullable = false)
    var url: String,

    @CreationTimestamp
    val created: Date = Date(),

    @UpdateTimestamp
    var modifier: Date = Date()
) {
    constructor() : this(
        null,
        "",
    )
}
