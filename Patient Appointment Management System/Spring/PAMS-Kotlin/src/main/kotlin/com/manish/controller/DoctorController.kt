package com.manish.controller

import com.manish.service.DoctorService
import com.manish.model.Doctor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class DoctorController(@Autowired val doctorService : DoctorService){

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @GetMapping("doctor")
        fun viewAllDoctors() : List<Doctor>
        {
          return doctorService.viewAllDoctors()
        }

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @GetMapping("doctor/id/{did}")
        fun viewDoctorByID(@PathVariable did : Int) : Doctor{
            return doctorService.viewDoctorByID(did)
        }

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @GetMapping("doctor/name/{dname}")
        fun viewDoctorByName(@PathVariable dname : String) : Doctor {
            return doctorService.viewDoctorByName(dname)
        }

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @PostMapping("doctor")
        fun addDoctor(@RequestBody doctor : Doctor) : Doctor
        {
            return doctorService.addDoctor(doctor)
        }

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @PutMapping("doctor/id/{did}")
        fun updateDoctor(@RequestBody doctor : Doctor , @PathVariable did : Int) : Doctor{
            var doctorDetails : Doctor = doctorService.viewDoctorByID(did);
            doctorDetails.doctorName = doctor.doctorName
            doctorDetails.address = doctor.address
            doctorDetails.departmentNo = doctor.departmentNo
            doctorDetails.phone =  doctor.phone
            doctorDetails.email = doctor.email
            doctorDetails.qualification = doctor.qualification
            return doctorService.updateDoctor(doctorDetails)
        }

        @CrossOrigin(origins = arrayOf("http://localhost:3000"))
        @DeleteMapping("doctor/id/{did}")
        fun disableDoctor(@PathVariable did : Int) : String
        {
            var doctorDetails : Doctor = doctorService.viewDoctorByID(did);
            doctorDetails.status=0
            return doctorService.disableDoctor(doctorDetails)
        }
}