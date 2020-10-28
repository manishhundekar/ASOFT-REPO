package Service

import DAO_Imp.DoctorDAOImpl
import model.Doctor

class DoctorService {
    var doctorDAO = DoctorDAOImpl()

    fun listDoctors() {
        doctorDAO.listDoctors()
    }

    fun addDoctor(doctor: Doctor) {
        doctorDAO.addDoctor(doctor)
    }

    fun searchDoctorByID(did: Int?) {
        doctorDAO.searchDoctorByID(did)
    }

    fun searchDoctorByName(dname: String?) {
        doctorDAO.searchDoctorByName(dname)
    }

    fun updateDoctorName(did: Int?, dname: String?) {
        doctorDAO.updateDoctorName(did,dname)
    }

    fun updateDoctorQual(did: Int?, dqual: String?) {
        doctorDAO.updateDoctorQual(did,dqual)
    }

    fun updateDoctorPhone(did: Int?, dph: String?) {
        doctorDAO.updateDoctorPhone(did,dph)
    }

    fun updateDoctorEmail(did: Int?, demail: String?) {
        doctorDAO.updateDoctorEmail(did,demail)
    }

    fun deleteDoctor(did: Int?) {
        doctorDAO.deleteDoctor(did)
    }

}