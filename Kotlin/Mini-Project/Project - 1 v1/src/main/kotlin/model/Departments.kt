package project.model

import project.dao.*

data class Departments(var deptID : Int , var deptName : String){}

class DeptServices
{
    companion object{
        fun dept_services() {
            println("Choose an option from the submenu")
            println("1.Add Dept \n2.View Departments \n3.Delete Dept" +
                    "\n4.Edit Dept \n5.Go back to main menu")
            when (readLine()?.toInt()) {
                1 -> this.addDept()
                2 -> this.viewDept()
                3 -> this.deleteDept()
                4 -> this.editDept()
                5 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }
        fun addDept()
        {

            println("----------------NEW DEPARTMENT------------------")
            println("Enter Department Name:")
            getConnection()
            readLine()?.let { DAO_newDept(it) } ?: println("Invalid Input")
            closeConnection()

        }

        fun viewDept(){
            println("----------------View Departments------------------")
            getConnection()
            DAO_viewDept()
            closeConnection()
        }

        fun deleteDept(){
            println("----------------Delete Department------------------")
            getConnection()
            DAO_viewDept()
            println("Enter Department ID:")
            DAO_delDept(readLine())
            closeConnection()
        }

        fun editDept(){
            println("----------------Edit Department------------------")
            println("UPDATE MENU \n1.Update Name \n2.Go back to main menu")
            when (readLine()?.toInt()) {
                1 -> {
                    getConnection()
                    DAO_viewDept()
                    println("Enter Department ID : ")
                    var did = readLine()?.toInt()
                    println("Enter the New Department Name : ")
                    var dname = readLine()
                    DAO_updateDeptName(did,dname)
                    closeConnection()
                }
                5 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }
    }
}