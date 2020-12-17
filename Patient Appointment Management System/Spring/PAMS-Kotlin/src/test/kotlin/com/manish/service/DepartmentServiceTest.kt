package com.manish.service

import com.manish.exception.DepartmentNotFoundException
import com.manish.service.DepartmentService
import com.manish.model.Department
import com.manish.repository.DepartmentRepository
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*


@SpringBootTest
class DepartmentServiceTest {

    @MockBean
    private var departmentRepository: DepartmentRepository? = null

    //@InjectMocks
    @Autowired
    var departmentService : DepartmentService? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun addDepartmentTest()
    {
        var department : Department = Department(1,"Pathology",1)
        Mockito.`when`(departmentRepository?.save(department)).thenReturn(department)
        val expected = department
        assertEquals(expected , departmentService?.addDepartment(department))
    }

    @Test
    fun listDeptTest()
    {
        var department1 : Department = Department(1,"Pathology",1)
        var department2 : Department = Department(1,"Cardiology",1)
        var department3 : Department = Department(1,"Endocrinology",1)

        var departmentList  = mutableListOf<Department>()
        departmentList.add(department1)
        departmentList.add(department2)
        departmentList.add(department3)

        Mockito.`when`(departmentRepository?.findAll()).thenReturn(departmentList)
        val expected = departmentList
        assertEquals(expected , departmentService?.listDept())
    }

    @Test
    fun viewDepartmentByIdTest()
    {
        var department : Department = Department(1,"Pathology",1)
        var dept : Optional<Department>? =  Optional.of(department)

        Mockito.`when`(departmentRepository?.findById(1)).thenReturn(dept)
        val expected1 = department
        assertEquals(expected1,departmentService?.viewDepartmentById(1))

        Mockito.`when`(departmentRepository?.findById(100)).thenThrow(DepartmentNotFoundException("Invalid Department ID ->100"))
        val expected2 = department
        assertThrows<DepartmentNotFoundException> {  departmentService?.viewDepartmentById(100) }

    }

    @Test
    fun viewDepartmentByNameTest()
    {
        var department : Department = Department(1,"Pathology",1)
        var dept : Optional<Department>? =  Optional.of(department)

        Mockito.`when`(departmentRepository?.findByDeptName("Pathology")).thenReturn(dept)
        val expected1 = department
        assertEquals(expected1,departmentService?.viewDepartmentByName("Pathology"))

        Mockito.`when`(departmentRepository?.findByDeptName("Oncology")).thenThrow(DepartmentNotFoundException("Invalid Department Name ->Oncology"))
        val expected2 = department
        assertThrows<DepartmentNotFoundException> {  departmentService?.viewDepartmentByName("Oncology") }

    }

    @Test
    fun disableDepartmentTest()
    {
        var department : Department = Department(1,"Pathology",1)
        Mockito.`when`(departmentRepository?.save(department)).thenReturn(department)
        val expected =department
        assertEquals(expected , departmentService?.disableDepartment(department))
    }

    @Test
    fun enableDepartmentTest()
    {
        var department : Department = Department(1,"Pathology",1)
        Mockito.`when`(departmentRepository?.save(department)).thenReturn(department)
        val expected =department
        assertEquals(expected , departmentService?.disableDepartment(department))
    }

    @Test
    fun updateDepartmentTest()
    {
        var department : Department = Department(1,"Pathology",1)
        Mockito.`when`(departmentRepository?.save(department)).thenReturn(department)
        val expected =department
        assertEquals(expected , departmentService?.disableDepartment(department))
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
