package com.manish.controller

import com.manish.service.UserService
import com.manish.model.User

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(@Autowired var userService : UserService)
{

    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @PostMapping("user")
    fun checkLogin(@RequestBody user : User) : Boolean{
        return userService.validateCred(user.userName, user.password)
        //return true
    }

}