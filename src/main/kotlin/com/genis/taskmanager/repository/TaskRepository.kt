package com.genis.taskmanager.repository

import com.genis.taskmanager.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>
