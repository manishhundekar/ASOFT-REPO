package com.manish.service

import com.manish.exception.DepartmentNotFoundException
import com.manish.model.Department
import com.manish.repository.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DepartmentService (@Autowired var departmentRepository: DepartmentRepository){

    fun addDepartment(department: Department): Department {
        return departmentRepository.save(department)
    }

    fun listDept(): List<Department> {
        return departmentRepository.findAll()
    }

    fun viewDepartmentById(did: Int): Department {
        return departmentRepository.findById(did).orElseThrow{ DepartmentNotFoundException("Invalid Department ID ->" + did) }
    }

    fun viewDepartmentByName(departmentName: String): Department {
        return departmentRepository.findByDeptName(departmentName).orElseThrow{ DepartmentNotFoundException("Invalid Department Name ->" + departmentName) }
    }

    fun disableDepartment(department: Department): Department {
        return departmentRepository.save(department)
    }

    fun updateDepartment(department: Department): Department {
        return departmentRepository.save(department)
    }

    fun enableDepartment(department: Department) : Department{
        return departmentRepository.save(department)
    }


}