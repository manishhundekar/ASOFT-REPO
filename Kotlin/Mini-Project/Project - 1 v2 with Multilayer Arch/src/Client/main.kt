package Client

import Controller.*
import java.lang.Exception
import kotlin.system.exitProcess

var logincontroller = LoginController();
var patientController = PatientController()
var doctorController = DoctorController()
var appointmentController = AppointmentController()
var deptController = DepartmentController()

fun main() {
    println("--------------Welcome to Hospital Appointment Management Portal---------")
    var flag: Boolean = true
    while (flag) {
        if (logincontroller.initiateLogin()) {
            flag = false
            while (true) {
                println("Choose an option from the menu")
                println("MENU \n1.Appointments \n2.Patient Records \n3.Manage Doctor \n4.Manage Patient \n5.Manage Departments \n6.Exit")
                try {
                    when (readLine()?.toInt()) {
                        1 -> appointmentController.appointmentMenu()
                        2 -> patientController.patientRecordsMenu()
                        3 -> doctorController.doctorMenu()
                        4 -> patientController.patientMenu()
                        5 -> deptController.deptMenu()
                        6 -> exitmenu()
                        else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
                    }
                } catch (e: NumberFormatException) {
                    println("INVALID ENTRY..\nTRY AGAIN")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}

fun exitmenu() {
    exitProcess(0);
}