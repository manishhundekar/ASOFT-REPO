package com.manish.service

import com.manish.exception.AppointmentNotFoundException
import com.manish.service.AppointmentService
import com.manish.model.Appointment
import com.manish.repository.AppointmentRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*


@SpringBootTest
class AppointmentServiceTest {

    @MockBean
    private var appointmentRepository: AppointmentRepository? = null

    //@InjectMocks
    @Autowired
    var appointmentService : AppointmentService? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun newAppointmentTest(){
        var appointment : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        Mockito.`when`(appointmentRepository?.save(appointment)).thenReturn(appointment)
        val expected = appointment
        Assertions.assertEquals(expected, appointmentService?.newAppointment(appointment))
    }

    fun viewAllAppointmentsTest() {
        var appointment1 : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment2 : Appointment = Appointment(2,Date(2020,12,12),"2020-12-15","09:00",5,15,"Out-Patient",
                "Viral Fever","Confirmed" )

        var appointmentList  = mutableListOf<Appointment>()
        appointmentList.add(appointment1)
        appointmentList.add(appointment2)

        Mockito.`when`(appointmentRepository?.findAll()).thenReturn(appointmentList)
        val expected = appointmentList
        Assertions.assertEquals(expected, appointmentService?.viewAllAppointments())
    }

    @Test
    fun appointmentByIdTest() {
        var appointment : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment1 : Optional<Appointment>? =  Optional.of(appointment)

        Mockito.`when`(appointmentRepository?.findById(1)).thenReturn(appointment1)
        val expected1 = appointment
        Assertions.assertEquals(expected1, appointmentService?.appointmentById(1))

        Mockito.`when`(appointmentRepository?.findById(100)).thenThrow(AppointmentNotFoundException("Invalid Appointment ID ->100"))
        assertThrows<AppointmentNotFoundException> {  appointmentService?.appointmentById(100) }

    }

    @Test
    fun upcomingAppointmentsTest(){
        var appointment1 : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment2 : Appointment = Appointment(2,Date(2020,12,12),"2020-12-15","09:00",5,15,"Out-Patient",
                "Viral Fever","Confirmed" )

        var appointmentList  = mutableListOf<Appointment>()
        appointmentList.add(appointment1)
        appointmentList.add(appointment2)

        Mockito.`when`(appointmentRepository?.upcomingAppointments()).thenReturn(appointmentList)
        val expected = appointmentList
        Assertions.assertEquals(expected, appointmentService?.upcomingAppointments())
    }

    @Test
    fun upcomingAppointmentsByDoctorIdTest(){
        var appointment1 : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment2 : Appointment = Appointment(2,Date(2020,12,12),"2020-12-15","09:00",5,5,"Out-Patient",
                "Viral Fever","Confirmed" )

        var appointmentList  = mutableListOf<Appointment>()
        appointmentList.add(appointment1)
        appointmentList.add(appointment2)

        Mockito.`when`(appointmentRepository?.upcomingAppointmentsByDoctorId(5)).thenReturn(appointmentList)
        val expected = appointmentList
        Assertions.assertEquals(expected, appointmentService?.upcomingAppointmentsByDoctorId(5))
    }

    @Test
    fun upcomingAppointmentsByDoctorNameTest(){
        var appointment1 : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment2 : Appointment = Appointment(2,Date(2020,12,12),"2020-12-15","09:00",5,5,"Out-Patient",
                "Viral Fever","Confirmed" )
        var name = "Ramesh"

        var appointmentList  = mutableListOf<Appointment>()
        appointmentList.add(appointment1)
        appointmentList.add(appointment2)

        Mockito.`when`(appointmentRepository?.upcomingAppointmentsByDoctorName(name)).thenReturn(appointmentList)
        val expected = appointmentList
        Assertions.assertEquals(expected, appointmentService?.upcomingAppointmentsByDoctorName(name))
    }

    @Test
    fun editAppointmentTest()
    {
        var appointment : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        Mockito.`when`(appointmentRepository?.save(appointment)).thenReturn(appointment)
        val expected =appointment
        Assertions.assertEquals(expected, appointmentService?.editappointment(appointment))
    }

    @Test
    fun cancelAppointmentTest()
    {
        var appointment : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        Mockito.`when`(appointmentRepository?.save(appointment)).thenReturn(appointment)
        val expected =appointment
        Assertions.assertEquals(expected, appointmentService?.cancelAppointment(appointment))
    }

    @Test
    fun confirmAppointmentTest()
    {
        var appointment : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",1,5,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        Mockito.`when`(appointmentRepository?.save(appointment)).thenReturn(appointment)
        val expected =appointment
        Assertions.assertEquals(expected, appointmentService?.confirmAppointment(appointment))
    }

    @Test
    fun appointmentByPatientIdTest(){
        var appointment1 : Appointment = Appointment(1,Date(2020,12,12),"2020-12-12","09:00",5,1,"In-Patient",
                "Leg Injury","Awaiting Confirmation" )
        var appointment2 : Appointment = Appointment(2,Date(2020,12,12),"2020-12-15","09:00",5,5,"Out-Patient",
                "Viral Fever","Confirmed" )

        var appointmentList  = mutableListOf<Appointment>()
        appointmentList.add(appointment1)
        appointmentList.add(appointment2)

        Mockito.`when`(appointmentRepository?.findBypatientId(5)).thenReturn(appointmentList)
        val expected = appointmentList
        Assertions.assertEquals(expected, appointmentService?.appointmentByPatientId(5))
    }

}
