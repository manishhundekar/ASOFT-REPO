package com.manish.controller

import com.manish.service.DepartmentService
import com.manish.model.Department
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RestController
class DepartmentController(@Autowired val departmentService : DepartmentService) {

    @PostMapping("department")
    fun addDepartment(@RequestBody department : Department) : Department {
       return departmentService.addDepartment(department)
    }

    @GetMapping("department")
    fun listAllDepartments() : List<Department>{
      return departmentService.listDept()
    }

    @GetMapping("department/id/{did}")
    fun viewDepartmentById(@PathVariable did : Int) :Department {
        return departmentService.viewDepartmentById(did)
    }

    @GetMapping("department/name/{departmentName}")
    fun viewDepartmentByName(@PathVariable departmentName : String) : Department {
        return departmentService.viewDepartmentByName(departmentName)
    }

    @PutMapping("department/disable/id/{did}")
    fun disableDepartment(@PathVariable did : Int) : String {
        var departmentDetails:Department = departmentService.viewDepartmentById(did)
        departmentDetails.status = 0
        departmentService.disableDepartment(departmentDetails)
        return "Department Disabled";
    }

    @PutMapping("department/enable/id/{did}")
    fun enableDepartment(@PathVariable did : Int) : String {
        var departmentDetails:Department = departmentService.viewDepartmentById(did)
        departmentDetails.status = 1
        departmentService.enableDepartment(departmentDetails)
        return "Department Enabled";
    }

    @PutMapping("department/id/{did}")
    fun updateDepartment(@RequestBody department : Department , @PathVariable did : Int) : Department{
        var departmentDetails : Department = departmentService.viewDepartmentById(did);
        departmentDetails.deptName = department.deptName
        return departmentService.updateDepartment(departmentDetails)
    }
}