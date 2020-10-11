package com.webbfontaine.kotlin.conf

import com.webbfontaine.kotlin.domain.User
import com.webbfontaine.kotlin.services.UserService
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Bootstrap {

    @Bean
    fun initRecords(userService: UserService) = ApplicationRunner {
        userService.save(User("sarawat", "Sarawat", "Guntithanon"))
        userService.save(User("bright", "Sarawat", "Chivaree"))
    }
}