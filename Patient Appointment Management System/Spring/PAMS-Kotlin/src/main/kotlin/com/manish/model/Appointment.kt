package com.manish.model


import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.sql.*
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "appointment")
data class Appointment(
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
         var appointmentId: Int,
        @Temporal(TemporalType.TIMESTAMP)
        @Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP" , nullable = true)
         var timestamp : Date,
        //var appDate: Date,
        //var appTime: LocalTime,
        var appDate: String,
        var appTime: String,
        var patientId: Int,
        var doctorId: Int,
        var category: String,
        var description: String,
        var status: String = "Awaiting Confirmation"
) {}
/*
@Temporal(TemporalType.TIMESTAMP)
@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
 Date timestamp = new Date();

data class Appointment(var appID: Int, var appDate: String, var patID: Int,
                       var docID: Int, var category: String, var description: String) {

}
*/