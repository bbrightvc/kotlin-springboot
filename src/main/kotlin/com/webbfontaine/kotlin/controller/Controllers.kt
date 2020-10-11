package com.webbfontaine.kotlin.controller

import com.webbfontaine.kotlin.domain.User
import com.webbfontaine.kotlin.services.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){

    @GetMapping("/")
    fun findAll(): MutableIterable<User> = userService.findAll()

    @GetMapping("/findByFirstName")
    fun findByFirstname(@RequestParam params: Map<String, Any>) : Any {
        val firstName: String = params["firstName"] as String? ?:""
        return userService.findFirstByFirstNameOrderById(firstName)
    }

}