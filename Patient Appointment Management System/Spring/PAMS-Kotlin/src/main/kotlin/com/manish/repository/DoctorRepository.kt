package com.manish.repository

import com.manish.model.Appointment
import com.manish.model.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface DoctorRepository : JpaRepository<Doctor, Int> {

    @Query("Select d from Doctor d where status = 1")
    override fun findAll(): MutableList<Doctor>

    abstract fun findByDoctorName(dname: String): Optional<Doctor>

}