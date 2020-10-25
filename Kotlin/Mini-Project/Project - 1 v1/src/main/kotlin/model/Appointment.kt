package project.model

import project.dao.*
import project.model.PatientServices.Companion.addPatient
import java.text.SimpleDateFormat
import java.util.*


data class Appointment(var appID : Int , var appDate : Date , var patID : Int,
                       var docID : Int , var category : String , var description : String , var status : String = "Under Confirmation"){}


class AppointmentServices{
    companion object{

        fun appointments_services() {
            println("Choose an option from the submenu")
            println("1.Create New Appointment \n2.Upcoming Appointments \n3.Upcoming Appointments by Doctor " +
                    "\n4.Cancel Appointment \n5.Appointment Status \n6.View all Appointments \n7.Go back to main menu")
            when (readLine()?.toInt()) {
                1 ->{
                    println("----------------NEW APPOINTMENT------------------")
                    println("SELECT AN OPTION : \n1.New Patient \n2.Returning Patient \n3.Go back to Main Menu")
                    when (readLine()?.toInt()) {
                        1 -> {
                            addPatient()
                            newAppointment()
                        }
                        2 -> newAppointment()
                        3 -> println()
                        else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
                    }
                }
                2 -> this.upcomingAppointmentsByDate();
                3 -> this.upcomingAppointmentsByDoctor();
                4 -> this.cancelAppointment();
                5 -> this.appointmentStatus();
                6 -> this.viewAllAppointments();
                6 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        //View all appointments
        fun viewAllAppointments()
        {
            getConnection()
            DAO_viewAllAppointments()
            closeConnection()
        }

        // New Appointment
        fun newAppointment()
        {
            getConnection()
            println("Select Patient :")
            DAO_listPatients()
            println("Enter Patient ID:")
            var pid = readLine()?.toInt()
            println("Enter Appointment Date (in YYYY-MM-DD format) :")
            var date = readLine()
            //Date Validation
            if((SimpleDateFormat("yyyy-MM-dd").parse(date).time) > Date().time)
            {
                println("Select Doctor :")
                DAO_viewAllDoc()
                println("Enter Doctor ID:")
                var did = readLine()?.toInt()
                println("Select Category : \n1.Out Patient \n2.Admission")
                var cate = when(readLine()?.toInt())
                {
                    1 -> "Out Patient"
                    2 -> "Admitted"
                    else -> "N/A"
                }
                println("Add Description :")
                var descrp = readLine()
                DAO_newAppointment(date,pid,did,cate,descrp)
            }
            else
            {
                println("Invalid Appointment Date")
            }
            //
            closeConnection()
        }

        //Upcoming appointments by Date
        fun upcomingAppointmentsByDate() {
            getConnection()
            println("----------------UPCOMING APPOINTMENTS BY DATE------------------")
            DAO_upcomingAppointmentsByDate()
            closeConnection()
        }

        //Upcoming Appointment by Doctor
        fun upcomingAppointmentsByDoctor() {
            getConnection()
            println("----------------UPCOMING APPOINTMENTS BY DOCTOR------------------")
            println("Enter Doctor ID :")
            var did = readLine()?.toInt()
            DAO_upcomingAppointmentsByDoctor(did)
            closeConnection()
        }

        //Cancel Appointment
        fun cancelAppointment()
        {
            getConnection()
            println("----------------CANCEL APPOINTMENT------------------")
            println("Select Appointment :")
            DAO_viewAllAppointments()
            println("Enter Appointment ID :")
            var aid = readLine()?.toInt()
            DAO_cancelAppointment(aid)
            closeConnection()
        }

        //Appointment Status
        fun appointmentStatus()
        {
            getConnection()
            println("----------------APPOINTMENT STATUS------------------")
            println("Select Appointment :")
            DAO_viewAllAppointments()
            println("Enter Appointment ID :")
            var aid = readLine()?.toInt()
            DAO_appointmentStatus(aid)
            closeConnection()
        }
    }
}