package project.model

import project.dao.*
import project.model.DeptServices.Companion.viewDept


data class Doctor (var docID:Int , var docName:String , var deptNo : Int , var qual:String ,
                   var address:String , var phone:String , var email:String , var doj:String) {}

class DoctorServices
{
    companion object{
        fun doctor_services() {
            println("Choose an option from the submenu")
            println("1.Add Doctor \n2.Search Doctor by ID \n3.Search Doctor by Name " +
                    "\n4.Edit Doctor \n5.Delete Doctor \n6.View all Doctors\n7.Go back to main menu")
            when (readLine()?.toInt()) {
                1 -> this.addDoctor()
                2 -> this.searchDoctorByID()
                3 -> this.searchDoctorByName()
                4 -> this.editDoctor()
                5 -> this.deleteDoctor()
                6 -> this.viewAllDoctors()
                7 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun viewAllDoctors()
        {
            getConnection()
            DAO_viewAllDoc()
            closeConnection()
        }
        fun addDoctor()
        {
            getConnection()
            println("----------------NEW DOCTOR------------------")
            println("Enter Doctor Name:")
            var name = readLine()
            println("Select Department:")
            DAO_viewDept()
            println("Enter Department ID:")
            var did = readLine()?.toInt()
            println("Enter Doctor Qualification:")
            var qual = readLine()
            println("Enter Doctor Address:")
            var add = readLine()
            println("Enter Doctor Phone:")
            var phn = readLine();
            println("Enter Doctor e-mail:")
            var email = readLine()
            println("Enter Doctor's  Date of Joining:")
            var doj = readLine()
            DAO_addDoctor(name,did,qual,add,phn,email,doj)
            closeConnection()
        }

        fun searchDoctorByID(){
            getConnection()
            println("----------------SEARCH DOCTOR BY ID------------------")
            println("Enter DOCTOR ID:")
            var did = readLine()?.toInt()
            DAO_searchDoctorByID(did)
            closeConnection()
        }

        fun searchDoctorByName(){
            println("----------------SEARCH DOCTOR BY NAME------------------")
            println("Enter Doctor Name:")
            getConnection()
            var dname = readLine()
            DAO_searchDoctorByName(dname)
            closeConnection()
        }

        fun editDoctor(){
            println("----------------EDIT DOCTOR------------------")
            println("UPDATE MENU \n1.Update Name \n2.Update Qualification \n3.Update Phone \n4.Update e-mail \n5.Go back")
            when (readLine()?.toInt()) {
                1 -> {
                    getConnection()
                    DAO_viewAllDoc()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter New Doctor Name : ")
                    var dname = readLine()
                    DAO_updateDoctorName(did,dname)
                    closeConnection()
                }
                2 -> {
                    getConnection()
                    DAO_viewAllDoc()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Qual : ")
                    var dqual = readLine()
                    DAO_updateDoctorQual(did,dqual)
                    closeConnection()
                }
                3 -> {
                    getConnection()
                    DAO_viewAllDoc()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Phone No : ")
                    var dph = readLine()
                    DAO_updateDoctorPhone(did,dph)
                    closeConnection()
                }

                4 -> {
                    getConnection()
                    DAO_viewAllDoc()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Email : ")
                    var demail = readLine()
                    DAO_updateDoctorEmail(did,demail)
                    closeConnection()
                }

                5 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun deleteDoctor()
        {
            println("----------------DELETE DOCTOR------------------")
            getConnection()
            DAO_viewAllDoc()
            println("Enter Doctor ID : ")
            var did = readLine()?.toInt()
            DAO_deleteDoctor(did)
            closeConnection()
        }
    }
}

//var doc = Doctor(1001,"Ramesh",1,"MBBS MD","Bidar","9876543210","ramesh@gmail.com","25/01/2019")
//var doc = Doctor(1001, "Ramesh", 1, "MBBS MD",
//"Bidar", "9876543210", "ramesh@gmail.com", "25/01/2019")
// print(doc.address)
