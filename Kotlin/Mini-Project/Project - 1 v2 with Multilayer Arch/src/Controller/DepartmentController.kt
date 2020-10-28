package Controller

import Service.DepartmentService

class DepartmentController {

    var departmentService = DepartmentService()

    fun deptMenu() {
        println("Choose an option from the submenu")
        println("1.Add Dept \n2.List Departments \n3.Delete Dept" +
                "\n4.Edit Dept \n5.Go back to main menu")
        when (readLine()?.toInt()) {
            1 -> this.addDept()
            2 -> this.listDept()
            3 -> this.deleteDept()
            4 -> this.editDept()
            5 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }

    fun addDept() {
        println("----------------NEW DEPARTMENT------------------")
        println("Enter Department Name:")
        var dName = readLine()!!
        departmentService.addDept(dName)

    }

    fun listDept() {
        println("----------------List Departments------------------")
        departmentService.listDept()
    }

    fun deleteDept() {
        println("----------------Delete Department------------------")
        departmentService.listDept()
        println("Enter Department ID:")
        var did = readLine()!!
        departmentService.delDept(did)
    }

    fun editDept() {
        println("----------------Edit Department------------------")
        println("UPDATE MENU \n1.Update Name \n2.Go back to main menu")
        when (readLine()?.toInt()) {
            1 -> {
                departmentService.listDept()
                println("Enter Department ID : ")
                var did = readLine()?.toInt()
                println("Enter the New Department Name : ")
                var dname = readLine()
                departmentService.updateDeptName(did, dname)
            }
            5 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }
}