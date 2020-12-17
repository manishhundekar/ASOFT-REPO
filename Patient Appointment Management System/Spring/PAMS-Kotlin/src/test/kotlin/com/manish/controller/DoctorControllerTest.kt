package com.manish.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.manish.controller.DoctorController
import com.manish.model.Doctor
import com.manish.service.DoctorService
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(DoctorController::class)
class DoctorControllerTest(@Autowired var mvc: MockMvc) {

    @MockBean
    val doctorService: DoctorService? = null

    @Test
    @Throws(Exception::class)
    fun addDoctorTest() {
        val objectMapper = ObjectMapper()
        var doctor : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        mvc.perform(MockMvcRequestBuilders
                .post("/doctor")
                .content(objectMapper.writeValueAsString(doctor))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun viewAllDoctorsTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/doctor")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun viewDoctorByIdTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/doctor/id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun viewDoctorByNameTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/doctor/name/Ramesh")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun updateDoctorTest() {
        val objectMapper = ObjectMapper()
        var doctor : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        Mockito.`when`(doctorService?.viewDoctorByID(15)).thenReturn(doctor)
        mvc.perform(MockMvcRequestBuilders
                .put("/doctor/id/15")
                .content(objectMapper.writeValueAsString(doctor))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun disableDoctorTest() {
        val objectMapper = ObjectMapper()
        var doctor : Doctor = Doctor(1,"Ramesh",5,"M.B.B.S M.D","Rajajinagar , Bangalore" ,
                "7894174580","ramesh@gmail.com",1)
        Mockito.`when`(doctorService?.viewDoctorByID(15)).thenReturn(doctor)
        mvc.perform(MockMvcRequestBuilders
                .delete("/doctor/id/15")
                .content(objectMapper.writeValueAsString(doctor))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

}