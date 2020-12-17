package com.manish.repository

import com.manish.model.Appointment
import com.manish.model.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface PatientRepository : JpaRepository<Patient, Int> {

    @Query("Select p from Patient p where status = 1")
    override fun findAll(): MutableList<Patient>

    fun findByName(name: String): Optional<Patient>

    @Query("Select p from Patient p , Appointment a where a.patientId=p.pId AND a.category=?1 AND a.status!='Cancelled'  AND p.status = 1")
    abstract fun findByCategory(s: String): List<Patient>

}