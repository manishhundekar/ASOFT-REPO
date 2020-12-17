package com.manish.service

import com.manish.model.User
import com.manish.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired var userRepository: UserRepository) {
    fun validateCred(userName: String, password: String): Boolean {
        if(userRepository.validateCred(userName,password) > 0)
        {
            return true
        }
        return false
    }

}