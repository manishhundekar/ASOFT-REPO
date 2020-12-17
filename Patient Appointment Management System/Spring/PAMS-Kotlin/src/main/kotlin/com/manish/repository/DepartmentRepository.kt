package com.manish.repository
import com.manish.model.Appointment
import com.manish.model.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface DepartmentRepository : JpaRepository<Department, Int> {

    @Query("Select d from Department d where status = 1")
    override fun findAll(): MutableList<Department>

    fun findByDeptName(departmentName: String): Optional<Department>

}