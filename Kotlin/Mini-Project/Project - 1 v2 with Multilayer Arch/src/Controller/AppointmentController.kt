package Controller

import Service.AppointmentService
import model.Appointment

class AppointmentController{

    private var appointmentService = AppointmentService()
    private var patientController = PatientController()
    private var doctorController = DoctorController()

    fun appointmentMenu() {
        println("Choose an option from the submenu")
        println("1.Create New Appointment \n2.Upcoming Appointments \n3.Upcoming Appointments by Doctor " +
                "\n4.Cancel Appointment \n5.Appointment Status \n6.View all Appointments \n7.Go back to main menu")
        when (readLine()?.toInt()) {
            1 ->{
                println("----------------NEW APPOINTMENT------------------")
                println("SELECT AN OPTION : \n1.New Patient \n2.Returning Patient \n3.Go back to Main Menu")
                when (readLine()?.toInt()) {
                    1 -> {
                        Client.patientController.addPatient()
                        this.newAppointment()
                    }
                    2 -> this.newAppointment()
                    3 -> println()
                    else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
                }
            }
            2 -> this.upcomingAppointments();
            3 -> this.upcomingAppointmentsByDoctor();
            4 -> this.cancelAppointment();
            5 -> this.appointmentStatus();
            6 -> this.viewAllAppointments();
            7 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }

    fun newAppointment()
    {
        println("Select Patient :")
        patientController.listPatients()
        println("Enter Patient ID:")
        var pid = readLine()?.toInt()

        println("Enter Appointment Date (in YYYY-MM-DD format) :")
        var date = readLine()

        println("Select Doctor :")
        doctorController.listDoctors()
        println("Enter Doctor ID:")
        var did = readLine()?.toInt()

        println("Select Category : \n1.Out-Patient \n2.In-Patient Admission")
        var cate = when(readLine()?.toInt())
        {
            1 -> "Out Patient"
            2 -> "Admitted"
            else -> "N/A"
        }

        println("Add Description :")
        var descrp = readLine()

        var appointment = Appointment(date!!,pid!!,did!!,cate,descrp!!)
        appointmentService.newAppointment(appointment)
    }

    fun upcomingAppointments(){
        println("----------------UPCOMING APPOINTMENTS BY DATE------------------")
        appointmentService.upcomingAppointments()
    }

    fun upcomingAppointmentsByDoctor() {
        println("----------------UPCOMING APPOINTMENTS BY DOCTOR------------------")
        println("Enter Doctor ID :")
        var did = readLine()?.toInt()
        appointmentService.upcomingAppointmentsByDoctor(did)
    }

    fun cancelAppointment()
    {
        println("----------------CANCEL APPOINTMENT------------------")
        println("Select Appointment :")
        viewAllAppointments()
        println("Enter Appointment ID :")
        var aid = readLine()?.toInt()
        appointmentService.cancelAppointment(aid)
    }

    fun appointmentStatus()
    {
        println("----------------APPOINTMENT STATUS------------------")
        println("Select Appointment :")
        viewAllAppointments()
        println("Enter Appointment ID :")
        var aid = readLine()?.toInt()
        appointmentService.appointmentStatus(aid)
    }

    fun viewAllAppointments()
    {
        appointmentService.viewAllAppointments()
    }
}