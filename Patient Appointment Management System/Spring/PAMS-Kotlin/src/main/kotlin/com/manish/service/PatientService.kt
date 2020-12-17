package com.manish.service

import com.manish.exception.DoctorNotFoundException
import com.manish.exception.InvalidUserDataException
import com.manish.model.Patient
import com.manish.repository.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PatientService (@Autowired var patientRepository: PatientRepository){

    fun viewAllPatients(): List<Patient> {
        return patientRepository.findAll()
    }

    fun viewPatientByID(pid: Int): Patient {
        return patientRepository.findById(pid).orElseThrow{ DoctorNotFoundException("Invalid Patient ID ->" + pid) }
    }

    fun viewPatientByName(name: String): Patient {
        return patientRepository.findByName(name).orElseThrow{ DoctorNotFoundException("Invalid Patient Name ->" + name) }
    }

    //fun addPatient(patient: Patient) : Patient {
    //    return patientRepository.save(patient)
    //}

    fun addPatient(patient : Patient) : Patient{
        val namePattern = "[a-zA-Z ]+"
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if(patient.name.length>2 && patient.name.length<=30 && patient.name.matches(namePattern.toRegex()))
        {
            if(patient.age>0 && patient.age<130)
            {
                if(patient.email.matches(emailPattern.toRegex()))
                {
                    if(patient.gender.equals("Male") || patient.gender.equals("Female")){
                        return patientRepository.save(patient)
                    }
                    else
                    {
                        throw InvalidUserDataException("Invalid Gender Input - Either Male/Female is accepted")
                    }
                }
                else
                {
                    throw InvalidUserDataException("Invalid Email Format")
                }
            }
            else
            {
                throw InvalidUserDataException("Invalid Age")
            }
        }
        else{
            throw InvalidUserDataException("Invalid Name Input - Min.2 characters and Max.30 characters is accepted")
        }
    }

    fun disablePatient(patient: Patient) : Patient{
        return patientRepository.save(patient)
    }

    fun viewAllInPatient(): List<Patient> {
        return patientRepository.findByCategory("In-Patient")
    }

    fun viewAllOutPatient(): List<Patient> {
        return patientRepository.findByCategory("Out-Patient")
    }


}