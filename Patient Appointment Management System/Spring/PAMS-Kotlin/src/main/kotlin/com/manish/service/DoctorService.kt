package com.manish.service

import com.manish.exception.DoctorNotFoundException
import com.manish.model.Doctor
import com.manish.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DoctorService (@Autowired var doctorRepository: DoctorRepository){

    fun viewAllDoctors(): List<Doctor> {
        return doctorRepository.findAll()
    }

    fun viewDoctorByID(did: Int): Doctor {
        return doctorRepository.findById(did).orElseThrow{ DoctorNotFoundException("Invalid Doctor ID ->" + did) }
    }

    fun viewDoctorByName(dname: String): Doctor {
        return doctorRepository.findByDoctorName(dname).orElseThrow{ DoctorNotFoundException("Invalid Doctor Name ->" + dname) }
    }

    fun addDoctor(doctor: Doctor): Doctor {
        return doctorRepository.save(doctor)
    }

    fun updateDoctor(doctor: Doctor): Doctor {
        return doctorRepository.save(doctor)
    }

    fun disableDoctor(doctor: Doctor): String {
        doctorRepository.save(doctor)
        return "Doctor Disabled";
    }


}