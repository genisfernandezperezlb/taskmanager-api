package com.genis.taskmanager.controller

import com.genis.taskmanager.model.Task
import com.genis.taskmanager.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val service: TaskService) {

    @GetMapping
    fun getAll() = service.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.findById(id)

    @PostMapping
    fun create(@RequestBody task: Task) = service.create(task)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task) =
        service.update(id, task)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
