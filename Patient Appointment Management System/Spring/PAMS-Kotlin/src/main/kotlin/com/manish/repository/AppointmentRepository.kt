package com.manish.repository

import com.manish.model.Appointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AppointmentRepository : JpaRepository<Appointment, Int> {

    //@Query("Select a from Appointment a where status = 1")
    override fun findAll(): MutableList<Appointment>

    @Query("Select a from Appointment a where a.appDate > CURDATE()")
    fun upcomingAppointments(): List<Appointment>

    @Query("Select a from Appointment a where a.appDate > CURDATE() AND a.doctorId = ?1")
    fun upcomingAppointmentsByDoctorId(did : Int): List<Appointment>

    @Query("Select a from Appointment a , Doctor d where a.doctorId=d.doctorId AND a.appDate > CURDATE() AND d.doctorName = ?1")
    fun upcomingAppointmentsByDoctorName(dname: String): List<Appointment>

    @Query("Select a from Appointment a where a.patientId = ?1")
    fun findBypatientId(pid: Int): MutableList<Appointment>

}