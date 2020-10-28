package DAO

import model.Appointment

interface AppointmentDAO {
    fun viewAllAppointments()
    fun newAppointment(appointment: Appointment)
    fun upcomingAppointmentsByDoctor(did: Int?)
    fun upcomingAppointments()
    fun cancelAppointment(aid: Int?)
    fun appointmentStatus(aid : Int?)
}