package com.manish.controller

import com.manish.model.Doctor
import com.manish.service.PatientService
import com.manish.model.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RestController
class PatientController(@Autowired var patientServices : PatientService) {

    @GetMapping("patient")
    fun viewAllPatients() : List<Patient>{
        return patientServices.viewAllPatients()
    }

    @GetMapping("patient/id/{pid}")
    fun viewPatientByID(@PathVariable pid : Int) : Patient {
        return patientServices.viewPatientByID(pid)
    }

    @GetMapping("patient/name/{name}")
    fun viewPatientByName(@PathVariable name : String) : Patient {
        return patientServices.viewPatientByName(name)
    }

    @PostMapping("patient")
    fun addPatient(@RequestBody patient : Patient) : Patient{
        return patientServices.addPatient(patient)
    }

    @PutMapping("patient/id/{id}")
    fun editPatient(@PathVariable id : Int ,@RequestBody patient : Patient) : Patient{
        return patientServices.addPatient(patient)
    }

    @PostMapping("patient/disable/id/{pid}")
    fun disablePatient(@PathVariable pid : Int) : String {
        var patientDetails: Patient = patientServices.viewPatientByID(pid)
        patientDetails.status = 0
        patientServices.disablePatient(patientDetails)
        return "Patient Disabled"
    }

    @GetMapping("patient/category/inpatient")
    fun viewAllInPatient() : List<Patient> {
        return patientServices.viewAllInPatient()
    }

    @GetMapping("patient/category/outpatient")
    fun viewAllOutPatient() : List<Patient> {
        return patientServices.viewAllOutPatient()
    }
    /*
    fun searchPatientRecordsByID() {
        println("----------------PATIENT RECORDS BY ID------------------")
        this.listPatients()
        println("Enter Patient ID : ")
        var pid = readLine()?.toInt()
        patientServices.searchRecordById(pid!!)
    }

    fun searchPatientRecordsByName() {
        println("----------------PATIENT RECORDS BY Name------------------")
        println("Enter Patient Name : ")
        var pid = readLine()
        patientServices.searchRecordByName(pid!!)
    }

    fun showAdmittedPatients() {
        println("----------------ADMITTED PATIENTS------------------")
        patientServices.showAdmittedPat()
    }
    */

}