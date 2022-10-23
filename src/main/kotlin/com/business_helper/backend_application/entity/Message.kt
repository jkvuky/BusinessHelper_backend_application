package com.business_helper.backend_application.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "MESSAGES")
data class Message(

    @javax.persistence.Id @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,

    @Column(name = "WORKER", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "WORKER_ID")
    val workers: List<Workers>,

    @Column(name = "DATE", nullable = false)
    val date: LocalDateTime,

    @Column(name = "ITEMS", nullable = false)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEMS_ID")
    val items: List<Items>,

    @Column(name = "MESSAGE", nullable = true)
    val message: String,

    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var modifier: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(
        null,
        listOf(),
        LocalDateTime.now(),
        listOf(),
        "",
    )
}
