package com.genis.taskmanager.service

import com.genis.taskmanager.model.Task
import com.genis.taskmanager.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repo: TaskRepository) {

    fun findAll(): List<Task> = repo.findAll()

    fun findById(id: Long): Task =
        repo.findById(id).orElseThrow { RuntimeException("Task not found") }

    fun create(task: Task): Task = repo.save(task)

    fun update(id: Long, updated: Task): Task {
        val existing = findById(id)
        val merged = existing.copy(
            title = updated.title,
            description = updated.description,
            completed = updated.completed
        )
        return repo.save(merged)
    }

    fun delete(id: Long) = repo.deleteById(id)
}
