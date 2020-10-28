package DAO

import model.Patient

interface PatientDAO {
    fun addPatient(patient : Patient)
    fun searchPatientByID(id: Int?)
    fun searchPatientByName(name: String)
    fun updatePatientName(did: Int?, dname: String?)
    fun updatePatientAge(did: Int?, dage: Int?)
    fun updatePatientPhone(did: Int?, dph: String?)
    fun updatePatientEmail(did: Int?, demail: String?)
    fun deletePatient(id: Int?)
    fun searchRecordById(pid : Int)
    fun searchRecordByName(pname : String)
    fun showAdmittedPat()
    fun listPatients()

}