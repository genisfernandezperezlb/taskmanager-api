package com.genis.taskmanager.controller

import com.genis.taskmanager.model.User
import com.genis.taskmanager.repository.UserRepository
import com.genis.taskmanager.security.JwtService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userRepo: UserRepository,
    private val jwtService: JwtService
) {

    private val encoder = BCryptPasswordEncoder()

    @PostMapping("/register")
    fun register(@RequestBody user: User): User {
        val encodedPassword: String = encoder.encode(user.password).toString()

        val newUser = User(
            username = user.username,
            password = encodedPassword
        )
        return userRepo.save(newUser)
    }

    @PostMapping("/login")
    fun login(@RequestBody user: User): Map<String, String> {

        val dbUser = userRepo.findByUsername(user.username)
            ?: throw RuntimeException("User not found")

        if (!encoder.matches(user.password, dbUser.password)) {
            throw RuntimeException("Invalid password")
        }

        val token = jwtService.generateToken(user.username)

        return mapOf("token" to token)
    }
}