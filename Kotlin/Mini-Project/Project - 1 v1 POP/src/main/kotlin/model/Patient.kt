package project.model

import project.dao.*


data class Patient (var pID:Int , var pName:String , var pAge : Int , var pGender:String ,
                   var pAddress:String , var pPhone:String , var pEmail:String , var pMedHistory:String) {}

class PatientServices
{
    companion object{
        fun patient_services() {
            println("Choose an option from the submenu")
            println("1.Add Patient \n2.Search Patient by ID \n3.Search Patient by Name " +
                    "\n4.Edit Patient \n5.Delete Patient\n6.List all Patients  \n7.Go back to main menu")
            when (readLine()?.toInt()) {
                1 -> this.addPatient()
                2 -> this.searchPatientByID()
                3 -> this.searchPatientByName()
                4 -> this.editPatient()
                5 -> this.deletePatient()
                6 -> {
                    getConnection()
                    DAO_listPatients()
                    closeConnection()
                }
                7 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun addPatient()
        {
            println("----------------NEW PATIENT------------------")
            getConnection()
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
            DAO_newPatient(name,age,gender,add,phone,email,mhis)
            closeConnection()
        }

        fun searchPatientByID(){
            println("----------------SEARCH PATIENT BY ID------------------")
            println("Enter Patient ID:")
            getConnection()
            DAO_searchPatientByID(readLine())
            closeConnection()
        }

        fun searchPatientByName(){
            println("----------------SEARCH PATIENT BY NAME------------------")
            println("Enter Patient Name:")
            getConnection()
            DAO_searchPatientByName(readLine()!!)
            closeConnection()
        }

        fun editPatient(){
            println("----------------EDIT PATIENT------------------")
            println("UPDATE MENU \n1.Update Name \n2.Update Age \n3.Update Phone \n4.Update e-mail \n5.Go Back")
            when (readLine()?.toInt()) {
                1 -> {
                    getConnection()
                    DAO_listPatients()
                    println("Enter Patient ID : ")
                    var did = readLine()?.toInt()
                    println("Enter the New Patient Name : ")
                    var dname = readLine()
                    DAO_updatePatientName(did,dname)
                    closeConnection()
                }
                2 -> {
                    getConnection()
                    DAO_listPatients()
                    println("Enter Patient ID : ")
                    var did = readLine()?.toInt()
                    println("Enter the New Patient Age : ")
                    var dage = readLine()?.toInt()
                    DAO_updatePatientAge(did,dage)
                    closeConnection()
                }

                3 -> {
                    getConnection()
                    DAO_listPatients()
                    println("Enter Patient ID : ")
                    var did = readLine()?.toInt()
                    println("Enter the New Patient Phone : ")
                    var dph = readLine()
                    DAO_updatePatientPhone(did,dph)
                    closeConnection()
                }

                4 -> {
                    getConnection()
                    DAO_listPatients()
                    println("Enter Patient ID : ")
                    var did = readLine()?.toInt()
                    println("Enter the New Patient E-Mail : ")
                    var demail = readLine()
                    DAO_updatePatientEmail(did,demail)
                    closeConnection()
                }

                5 -> println()
                else -> println("INVALID MENU OPTION...\nPLEASE TRY AGAIN LATER")
            }
        }

        fun deletePatient()
        {
            println("----------------DELETE PATIENT------------------")
            getConnection()
            DAO_listPatients()
            println("Enter Patient ID : ")
            var did = readLine()?.toInt()
            DAO_deletePatient(did)
            closeConnection()
        }


        fun patient_records(){
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

        fun searchPatientRecordsByID()
        {
            println("----------------PATIENT RECORDS BY ID------------------")
            getConnection()
            println("Enter Patient ID : ")
            var pid = readLine()?.toInt()
            DAO_searchRecordById(pid!!)
            closeConnection()

        }

        fun searchPatientRecordsByName()
        {
            println("----------------PATIENT RECORDS BY Name------------------")
            getConnection()
            println("Enter Patient Name : ")
            var pid = readLine()
            DAO_searchRecordByName(pid!!)
            closeConnection()
        }

        fun showAdmittedPatients()
        {
            println("----------------ADMITTED PATIENTS------------------")
            getConnection()
            DAO_showAdmittedPat()
            closeConnection()
        }
    }
}