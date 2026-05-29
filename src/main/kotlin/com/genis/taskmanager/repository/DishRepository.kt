package com.genis.taskmanager.repository
import com.genis.taskmanager.model.Dish
import org.springframework.data.jpa.repository.JpaRepository
interface DishRepository : JpaRepository<Dish,Long>{}

