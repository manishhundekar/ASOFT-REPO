package com.manish.service

import com.manish.exception.AppointmentNotFoundException
import com.manish.exception.InvalidAppointmentCategoryException
import com.manish.exception.InvalidDateFormatException
import com.manish.model.Appointment
import com.manish.repository.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class AppointmentService(@Autowired var appointmentRepository: AppointmentRepository) {

    fun newAppointment(appointment: Appointment): Appointment {
        if(appointment.category.equals("In-Patient") or appointment.category.equals("Out-Patient"))
        {
            if((SimpleDateFormat("yyyy-MM-dd").parse(appointment.appDate.toString()).time) >= Date().time)
            {
                return appointmentRepository.save(appointment)
            }
            else
            {
                throw InvalidDateFormatException("Invalid Date - 1.Date Format Should be in YYYY-MM-DD 2.It Should be the future Date")
            }
        }
        else
        {
            throw InvalidAppointmentCategoryException("Invalid Category - Should be In-Patient or Out-Patient ")
        }

    }

    fun viewAllAppointments(): List<Appointment> {
        return appointmentRepository.findAll()
    }
    
    fun appointmentById(aid: Int): Appointment {
        return appointmentRepository.findById(aid).orElseThrow{ AppointmentNotFoundException("Invalid Appointment ID ->" + aid) }
    }

    fun upcomingAppointments(): List<Appointment> {
        return appointmentRepository.upcomingAppointments()
    }

    fun upcomingAppointmentsByDoctorId(did: Int): List<Appointment> {
        return appointmentRepository.upcomingAppointmentsByDoctorId(did)
    }

    fun upcomingAppointmentsByDoctorName(dname: String): List<Appointment> {
        return appointmentRepository.upcomingAppointmentsByDoctorName(dname)
    }

    fun editappointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun cancelAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun confirmAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun appointmentByPatientId(pid: Int): MutableList<Appointment> {
        return appointmentRepository.findBypatientId(pid)
    }


}