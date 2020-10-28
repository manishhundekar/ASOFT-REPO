package project

import project.dao.validateCred
import project.model.*
import java.lang.Exception
import kotlin.system.exitProcess

fun main() {
    println("--------------Welcome to Hospital Appointment Management Portal---------")
    var flag: Boolean = true
    while (flag) {
        println("Enter Username :")
        var username = readLine()
        println("Enter Password :")
        var password = readLine()
        if (validateCred(username, password)) {
            flag = false
            while (true) {
                println("Choose an option from the menu")
                println("MENU \n1.Appointments \n2.Patient Records \n3.Manage Doctor \n4.Manage Patient \n5.Manage Departments \n6.Exit")
                try {
                    when (readLine()?.toInt()) {
                        1 -> AppointmentServices.appointments_services()
                        2 -> PatientServices.patient_records()
                        3 -> DoctorServices.doctor_services()
                        4 -> PatientServices.patient_services()
                        5 -> DeptServices.dept_services()
                        6 -> exitmenu()
                        else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
                    }
                } catch (e: NumberFormatException) {
                    println("INVALID OPTION..\nTRY AGAIN")
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