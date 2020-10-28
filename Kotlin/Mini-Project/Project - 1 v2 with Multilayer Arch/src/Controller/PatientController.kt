package Controller

import Service.PatientService
import model.Patient

class PatientController {

    var patientServices = PatientService()

    fun patientMenu() {
        println("Choose an option from the submenu")
        println("1.Add Patient \n2.Search Patient by ID \n3.Search Patient by Name " +
                "\n4.Edit Patient \n5.Delete Patient\n6.List all Patients  \n7.Go back to main menu")
        when (readLine()?.toInt()) {
            1 -> this.addPatient()
            2 -> this.searchPatientByID()
            3 -> this.searchPatientByName()
            4 -> this.editPatientMenu()
            5 -> this.deletePatient()
            6 -> this.listPatients()
            7 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }

    fun listPatients(){
        patientServices.listPatients()
    }

    fun addPatient() {
        println("----------------NEW PATIENT------------------")
        println("Enter Patient Name:")
        var name = readLine()!!
        println("Enter Patient Age:")
        var age = readLine()!!
        println("Enter Patient Gender:")
        var gender = readLine()!!
        println("Enter Patient Address:")
        var add = readLine()!!
        println("Enter Patient Phone:")
        var phone = readLine()!!
        println("Enter Patient e-mail:")
        var email = readLine()!!
        println("Enter Patient Medical History (if any):")
        var mhis = readLine()!!
        var patient:Patient = Patient(name, age.toInt(), gender, add, phone, email, mhis);
        patientServices.addPatient(patient)
    }

    fun searchPatientByID() {
        println("----------------SEARCH PATIENT BY ID------------------")
        println("Enter Patient ID:")
        var pid = readLine()?.toInt()
        patientServices.searchPatientByID(pid)
    }

    fun searchPatientByName() {
        println("----------------SEARCH PATIENT BY NAME------------------")
        println("Enter Patient Name:")
        var name = readLine()!!
        patientServices.searchPatientByName(name)
    }

    fun deletePatient() {
        println("----------------DELETE PATIENT------------------")
        this.listPatients()
        println("Enter Patient ID : ")
        var did = readLine()?.toInt()
        patientServices.deletePatient(did)
    }

    fun editPatientMenu() {
        println("----------------EDIT PATIENT------------------")
        println("UPDATE MENU \n1.Update Name \n2.Update Age \n3.Update Phone \n4.Update e-mail \n5.Go Back")
        when (readLine()?.toInt()) {
            1 -> {
                patientServices.listPatients()
                println("Enter Patient ID : ")
                var did = readLine()?.toInt()
                println("Enter the New Patient Name : ")
                var dname = readLine()
                patientServices.updatePatientName(did, dname)
            }
            2 -> {
                patientServices.listPatients()
                println("Enter Patient ID : ")
                var did = readLine()?.toInt()
                println("Enter the New Patient Age : ")
                var dage = readLine()?.toInt()
                patientServices.updatePatientAge(did, dage)
            }

            3 -> {
                patientServices.listPatients()
                println("Enter Patient ID : ")
                var did = readLine()?.toInt()
                println("Enter the New Patient Phone : ")
                var dph = readLine()
                patientServices.updatePatientPhone(did, dph)
            }

            4 -> {
                patientServices.listPatients()
                println("Enter Patient ID : ")
                var did = readLine()?.toInt()
                println("Enter the New Patient E-Mail : ")
                var demail = readLine()
                patientServices.updatePatientEmail(did, demail)
            }

            5 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }

    //--------------------------------------------------------------------------------------
    fun patientRecordsMenu() {
        println("Choose an option from the submenu")
        println("1.Search Patient Records by ID \n2.Search Patient Records by Name \n3.Show Admitted Patients " +
                "\n4.Go back to main menu")
        when (readLine()?.toInt()) {
            1 -> this.searchPatientRecordsByID()
            2 -> this.searchPatientRecordsByName()
            3 -> this.showAdmittedPatients()
            4 -> println()
            else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
        }
    }

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
}