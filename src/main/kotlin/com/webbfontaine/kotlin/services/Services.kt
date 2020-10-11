package com.webbfontaine.kotlin.services

import com.webbfontaine.kotlin.domain.User
import org.springframework.data.repository.CrudRepository

interface UserService : CrudRepository<User, Long> {
    fun findAllById(id: Long): Iterable<User>
    fun findFirstByFirstNameOrderById(firstName: String): User
}
