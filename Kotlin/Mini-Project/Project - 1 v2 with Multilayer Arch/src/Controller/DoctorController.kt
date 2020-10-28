package Controller

import Service.DoctorService
import model.Doctor

class DoctorController{

    var doctorService = DoctorService()
    var deptController = DepartmentController()

        fun doctorMenu() {
            println("Choose an option from the submenu")
            println("1.Add Doctor \n2.Search Doctor by ID \n3.Search Doctor by Name " +
                    "\n4.Edit Doctor \n5.Delete Doctor \n6.View all Doctors\n7.Go back to main menu")
            when (readLine()?.toInt()) {
                1 -> this.addDoctor()
                2 -> this.searchDoctorByID()
                3 -> this.searchDoctorByName()
                4 -> this.editDoctor()
                5 -> this.deleteDoctor()
                6 -> this.listDoctors()
                7 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun listDoctors()
        {
            doctorService.listDoctors()
        }
        fun addDoctor()
        {
            println("----------------NEW DOCTOR------------------")
            println("Enter Doctor Name:")
            var name = readLine()
            println("Select Department:")
            deptController.listDept()
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
            var doctor = Doctor(name!!,did!!,qual!!,add!!,phn!!,email!!,doj!!)
            doctorService.addDoctor(doctor)
        }

        fun searchDoctorByID(){
            println("----------------SEARCH DOCTOR BY ID------------------")
            println("Enter DOCTOR ID:")
            var did = readLine()?.toInt()
            doctorService.searchDoctorByID(did)
        }

        fun searchDoctorByName(){
            println("----------------SEARCH DOCTOR BY NAME------------------")
            println("Enter Doctor Name:")
            var dname = readLine()
            doctorService.searchDoctorByName(dname)
        }

        fun editDoctor(){
            println("----------------EDIT DOCTOR------------------")
            println("UPDATE MENU \n1.Update Name \n2.Update Qualification \n3.Update Phone \n4.Update e-mail \n5.Go back")
            when (readLine()?.toInt()) {
                1 -> {
                    doctorService.listDoctors()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter New Doctor Name : ")
                    var dname = readLine()
                    doctorService.updateDoctorName(did,dname)
                }
                2 -> {
                    doctorService.listDoctors()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Qual : ")
                    var dqual = readLine()
                    doctorService.updateDoctorQual(did,dqual)
                }
                3 -> {
                    doctorService.listDoctors()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Phone No : ")
                    var dph = readLine()
                    doctorService.updateDoctorPhone(did,dph)
                }

                4 -> {
                    doctorService.listDoctors()
                    println("Enter Doctor ID : ")
                    var did = readLine()?.toInt()
                    println("Enter Email : ")
                    var demail = readLine()
                    doctorService.updateDoctorEmail(did,demail)
                }

                5 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun deleteDoctor()
        {
            println("----------------DELETE DOCTOR------------------")
            doctorService.listDoctors()
            println("Enter Doctor ID : ")
            var did = readLine()?.toInt()
            doctorService.deleteDoctor(did)
        }
}