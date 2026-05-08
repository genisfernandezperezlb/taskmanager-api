package com.genis.taskmanager.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val description: String?,
    val completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
