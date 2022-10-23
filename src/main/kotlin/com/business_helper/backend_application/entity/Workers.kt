package com.business_helper.backend_application.entity

import com.business_helper.backend_application.commons.data.TypeWorker
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "WORKERS")
data class Workers(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "surname", nullable = false)
    var surname: String,

    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "phone", nullable = false)
    var phone: String,

    @Column(name = "role", nullable = false)
    @Enumerated var role: TypeWorker,

    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    var modifier: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(
        null,
        "",
        "",
        "",
        "",
        "",
        TypeWorker.ADMIN
    )
}
