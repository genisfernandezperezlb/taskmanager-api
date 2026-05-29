package com.genis.taskmanager.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Reservation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val customerName: String,
    val reservationDate: LocalDateTime,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val dish: Dish
)
