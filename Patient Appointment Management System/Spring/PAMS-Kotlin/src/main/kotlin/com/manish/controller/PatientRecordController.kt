package com.manish.controller

import com.manish.service.AppointmentService
import com.manish.service.PatientService
import com.manish.model.PatientRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RestController
class PatientRecordController(@Autowired var appointmentService: AppointmentService ,@Autowired var patientService: PatientService) {

    @GetMapping("records/patient/{id}")
    fun viewPatientRecordsById(@PathVariable id : Int) : PatientRecord{
        return PatientRecord(patientService.viewPatientByID(id),appointmentService.appointmentByPatientId(id))
    }

}