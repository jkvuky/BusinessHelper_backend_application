package com.business_helper.backend_application.entity

import com.business_helper.backend_application.commons.data.TypeItems
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ITEMS")
data class Items(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "description", nullable = false)
    var description: String,

    @Column(name = "price", nullable = false)
    var price: Double,

    @Column(name = "quantity", nullable = false)
    var quantity: Int,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ITEMS_ID")
    @Column(name = "image", nullable = false)
    var image: List<Image>,

    @Column(name = "category", nullable = false)
    @Enumerated var category: TypeItems,

    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var modifier: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(
        null,
        "",
        "",
        0.0,
        0,
        listOf(),
        TypeItems.CABLE
    )
}

