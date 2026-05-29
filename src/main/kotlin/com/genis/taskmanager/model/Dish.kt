package com.genis.taskmanager.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Dish(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val description: String?,
    val price: Double,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
