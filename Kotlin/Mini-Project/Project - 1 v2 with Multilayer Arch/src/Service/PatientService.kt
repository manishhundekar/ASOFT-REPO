package Service

import DAO_Imp.PatientDAOImpl
import model.Patient

class PatientService {

    var patientDAO = PatientDAOImpl()

    fun listPatients(){
        patientDAO.listPatients()
    }

    fun addPatient(patient: Patient) {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if(patient.name.length>2 && patient.name.length>=30)
        {
            if(patient.age>0 && patient.age<130)
            {
                if(patient.email.matches(emailPattern.toRegex()))
                {
                    patientDAO.addPatient(patient)
                }
                else
                {
                    println("Invalid Email address")
                }
            }
            else
            {
                println("Invalid Age")
            }
        }
        else{
            println("Name Length should be Min. 2 characters and Max.30 Characters")
        }
    }

    fun searchPatientByID(pid: Int?) {
        patientDAO.searchPatientByID(pid)
    }

    fun searchPatientByName(name: String) {
        patientDAO.searchPatientByName(name)
    }

    fun deletePatient(did: Int?) {
        patientDAO.deletePatient(did)
    }

    fun updatePatientName(did: Int?, dname: String?) {
        patientDAO.updatePatientName(did, dname)
    }

    fun updatePatientAge(did: Int?, dage: Int?) {
        patientDAO.updatePatientAge(did, dage)
    }

    fun updatePatientPhone(did: Int?, dph: String?) {
        patientDAO.updatePatientPhone(did, dph)
    }

    fun updatePatientEmail(did: Int?, demail: String?) {
        patientDAO.updatePatientEmail(did, demail)
    }

    fun searchRecordById(pid: Int) {
        patientDAO.searchRecordById(pid)
    }

    fun searchRecordByName(pid: String) {
        patientDAO.searchRecordByName(pid)
    }

    fun showAdmittedPat() {
        patientDAO.showAdmittedPat()
    }


}