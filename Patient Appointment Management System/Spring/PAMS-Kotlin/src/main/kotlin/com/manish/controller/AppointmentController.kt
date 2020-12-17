package com.manish.controller

import com.manish.service.AppointmentService
import com.manish.service.DoctorService
import com.manish.service.PatientService
import com.manish.model.Appointment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RestController
class AppointmentController(@Autowired val appointmentService : AppointmentService,@Autowired val patientService: PatientService,@Autowired val doctorService: DoctorService){

    @PostMapping("appointment")
    fun newAppointment(@RequestBody appointment : Appointment) : Appointment
    {
        patientService.viewPatientByID(appointment.patientId)
        doctorService.viewDoctorByID(appointment.doctorId)
        return appointmentService.newAppointment(appointment)
    }

    @GetMapping("appointment")
    fun allAppointments() : List<Appointment>
    {
       return appointmentService.viewAllAppointments()
    }

    @GetMapping("appointment/{aid}")
    fun appointmentById(@PathVariable aid:Int) : Appointment {
        return appointmentService.appointmentById(aid)
    }

    @GetMapping("appointment/patient/{pid}")
    fun appointmentByPatientId(@PathVariable pid:Int) : List<Appointment> {
        return appointmentService.appointmentByPatientId(pid)
    }

    @GetMapping("appointment/upcoming/")
    fun upcomingAppointments() : List<Appointment>{
       return appointmentService.upcomingAppointments()
    }

    @GetMapping("appointment/upcoming/{did}")
    fun upcomingAppointmentsByDoctorId(@PathVariable did:Int) : List<Appointment>{
       return appointmentService.upcomingAppointmentsByDoctorId(did)
    }

    @GetMapping("appointment/upcoming/{dname}")
    fun upcomingAppointmentsByDoctorName(@PathVariable dname:String) : List<Appointment>{
        return appointmentService.upcomingAppointmentsByDoctorName(dname)
    }

    @PutMapping("appointment/{aid}")
    fun editappointmentById(@RequestBody appointment: Appointment , @PathVariable aid:Int) : Appointment{
        patientService.viewPatientByID(appointment.patientId)
        doctorService.viewDoctorByID(appointment.doctorId)
        var appointmentDetails : Appointment = appointmentService.appointmentById(aid);
        appointmentDetails.appDate = appointment.appDate
        appointmentDetails.appTime = appointment.appTime
        appointmentDetails.patientId = appointment.patientId
        appointmentDetails.doctorId = appointment.doctorId
        appointmentDetails.status = appointment.status
        appointmentDetails.category = appointment.category
        appointmentDetails.description = appointment.description
        return appointmentService.newAppointment(appointmentDetails)
    }

    @PutMapping("appointment/confirm/{aid}")
    fun confirmAppointment(@PathVariable aid:Int) : Appointment
    {
        var appointmentDetails : Appointment = appointmentService.appointmentById(aid);
        appointmentDetails.status = "Confirmed"
        return appointmentService.confirmAppointment(appointmentDetails)
    }

    @PutMapping("appointment/cancel/{aid}")
    fun cancelAppointment(@PathVariable aid:Int) : Appointment
    {
        var appointmentDetails : Appointment = appointmentService.appointmentById(aid);
        appointmentDetails.status = "Cancelled"
        return appointmentService.cancelAppointment(appointmentDetails)
    }

}