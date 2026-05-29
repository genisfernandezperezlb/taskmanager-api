package com.genis.taskmanager.controller

import com.genis.taskmanager.model.Dish
import com.genis.taskmanager.repository.DishRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dishes")

class DishController(private val dishRepository:com.genis.taskmanager.repository.DishRepository){

    @PostMapping fun createDish(@RequestBody dish: Dish): Dish {return dishRepository.save(dish)}
}

@GetMapping fun getAllDishes(): List<Dish>{return dishRepository.findAll()
}
