package com.manish.repository

import com.manish.model.Appointment
import com.manish.model.Patient
import com.manish.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
    @Query("Select count(u) from User u where u.userName=?1 and u.password=?2 ")
    fun validateCred(userName: String, password: String): Long

}