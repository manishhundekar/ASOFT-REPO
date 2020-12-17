package com.manish.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.manish.model.Department
import com.manish.service.DepartmentService
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


@WebMvcTest(DepartmentController::class)
class DepartmentControllerTest(@Autowired var mvc: MockMvc ) {

    @MockBean
    @Autowired
    val departmentService: DepartmentService? = null


    @Test
    @Throws(Exception::class)
    fun addDepartmentTest() {
        val objectMapper = ObjectMapper()
        val department : Department = Department(1,"Pathology",1)
        mvc.perform(MockMvcRequestBuilders
                .post("/department")
                .content(objectMapper.writeValueAsString(department))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun listAllDepartmentsTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/department")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }


    @Test
    @Throws(Exception::class)
    fun viewDepartmentByIdTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/department/id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun viewDepartmentByNameTest() {
        val objectMapper = ObjectMapper()
        mvc.perform(MockMvcRequestBuilders
                .get("/department/name/Pathology")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun updateDepartmentTest() {
        val objectMapper = ObjectMapper()
        val department : Department = Department(15,"Pathology",1)
        Mockito.`when`(departmentService?.viewDepartmentById(15)).thenReturn(department)
        mvc.perform(MockMvcRequestBuilders
                .put("/department/id/15")
                .content(objectMapper.writeValueAsString(department))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun enableDepartmentTest() {
        val objectMapper = ObjectMapper()
        val department : Department = Department(15,"Pathology",1)
        Mockito.`when`(departmentService?.viewDepartmentById(15)).thenReturn(department)
        mvc.perform(MockMvcRequestBuilders
                .put("/department/enable/id/15")
                .content(objectMapper.writeValueAsString(department))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun disableDepartmentTest() {
        val objectMapper = ObjectMapper()
        val department : Department = Department(15,"Pathology",1)
        Mockito.`when`(departmentService?.viewDepartmentById(15)).thenReturn(department)
        mvc.perform(MockMvcRequestBuilders
                .put("/department/disable/id/15")
                .content(objectMapper.writeValueAsString(department))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
    }
}