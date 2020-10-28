package DAO

import model.Doctor

interface DoctorDAO {
    fun listDoctors()
    fun addDoctor(doctor: Doctor)
    fun searchDoctorByID(did: Int?)
    fun searchDoctorByName(dname : String?)
    fun updateDoctorName(did: Int?, dname: String?)
    fun updateDoctorQual(did: Int?, dqual: String?)
    fun updateDoctorPhone(did: Int?, dph: String?)
    fun updateDoctorEmail(did: Int?, demail: String?)
    fun deleteDoctor(did : Int?)
}