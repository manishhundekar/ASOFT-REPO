package com.manish.service

import com.manish.exception.DepartmentNotFoundException
import com.manish.exception.DoctorNotFoundException
import com.manish.service.DoctorService
import com.manish.model.Doctor
import com.manish.repository.DoctorRepository
import org.junit.jupiter.api.Assertions.assertEquals
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
class DoctorServiceTest {

    @MockBean
    private var doctorRepository: DoctorRepository? = null

    //@InjectMocks
    @Autowired
    var doctorService : DoctorService? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun addDoctorTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        Mockito.`when`(doctorRepository?.save(doctor1)).thenReturn(doctor1)
        val expected = doctor1
        assertEquals(expected , doctorService?.addDoctor(doctor1))
    }

    @Test
    fun viewAllDoctorsTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        var doctor2 : Doctor = Doctor(2,"Suresh",6,"M.B.B.S M.D","Ganesh Nagar , Bangalore" ,
                "8874174584","suresh@gmail.com",1)

        var doctorList  = mutableListOf<Doctor>()
        doctorList.add(doctor1)
        doctorList.add(doctor2)

        Mockito.`when`(doctorRepository?.findAll()).thenReturn(doctorList)
        val expected = doctorList
        assertEquals(expected , doctorService?.viewAllDoctors())
    }

    @Test
    fun viewDoctorByIDTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        var doctor : Optional<Doctor>? =  Optional.of(doctor1)

        Mockito.`when`(doctorRepository?.findById(1)).thenReturn(doctor)
        val expected1 = doctor1
        assertEquals(expected1,doctorService?.viewDoctorByID(1))

        Mockito.`when`(doctorRepository?.findById(100)).thenThrow(DoctorNotFoundException("Invalid Doctor ID ->100"))
        assertThrows<DoctorNotFoundException> {  doctorService?.viewDoctorByID(100) }

    }

    @Test
    fun viewDepartmentByNameTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        var doctor : Optional<Doctor>? =  Optional.of(doctor1)

        Mockito.`when`(doctorRepository?.findByDoctorName("Ramesh")).thenReturn(doctor)
        val expected1 = doctor1
        assertEquals(expected1,doctorService?.viewDoctorByName("Ramesh"))

        Mockito.`when`(doctorRepository?.findByDoctorName("Suresh")).thenThrow(DoctorNotFoundException("Invalid Doctor Name ->Suresh"))
        assertThrows<DoctorNotFoundException> {  doctorService?.viewDoctorByName("Suresh") }

    }

    @Test
    fun disableDoctorTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        Mockito.`when`(doctorRepository?.save(doctor1)).thenReturn(doctor1)
        val expected ="Doctor Disabled"
        assertEquals(expected , doctorService?.disableDoctor(doctor1))
    }

    @Test
    fun updateDoctorTest()
    {
        var doctor1 : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        Mockito.`when`(doctorRepository?.save(doctor1)).thenReturn(doctor1)
        val expected =doctor1
        assertEquals(expected , doctorService?.updateDoctor(doctor1))
    }
    /*
    @Test
    fun addDetailsVerificationTest() {
        val user = User("1234", "RAM", "rampass")
        userService.addDetails(user)
        Mockito.verify<Any?>(userRepo, Mockito.atLeastOnce()).save(user)
    }
     */

}
