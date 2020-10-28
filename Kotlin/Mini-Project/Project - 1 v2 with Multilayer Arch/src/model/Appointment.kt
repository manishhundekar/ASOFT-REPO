package model

import java.util.*

data class Appointment(var appDate: String, var patID: Int,
                       var docID: Int, var category: String, var description: String) {

}
/*
data class Appointment(var appID: Int, var appDate: String, var patID: Int,
                       var docID: Int, var category: String, var description: String) {

}
*/