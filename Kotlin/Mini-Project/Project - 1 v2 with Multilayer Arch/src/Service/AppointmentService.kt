package Service

import DAO_Imp.AppointmentDAOImpl
import model.Appointment
import java.text.SimpleDateFormat
import java.util.*

class AppointmentService {
    var appointmentDAO = AppointmentDAOImpl()


    // New Appointment
    fun newAppointment(appointment : Appointment){
        if((SimpleDateFormat("yyyy-MM-dd").parse(appointment.appDate).time) > Date().time)
        {
            appointmentDAO.newAppointment(appointment)
        }
        else
        {
            println("Invalid Appointment Date")
        }
    }

    //Upcoming appointments by Date
    fun upcomingAppointments() {
        appointmentDAO.upcomingAppointments()
    }

    //Upcoming Appointment by Doctor
    fun upcomingAppointmentsByDoctor(did:Int?) {
        appointmentDAO.upcomingAppointmentsByDoctor(did)
    }

    //Cancel Appointment
    fun cancelAppointment(aid : Int?)
    {
        appointmentDAO.cancelAppointment(aid)
    }

    //Appointment Status
    fun appointmentStatus(aid: Int?)
    {
        appointmentDAO.appointmentStatus(aid)
    }

    //View all appointments
    fun viewAllAppointments()
    {
        appointmentDAO.viewAllAppointments()
    }
}