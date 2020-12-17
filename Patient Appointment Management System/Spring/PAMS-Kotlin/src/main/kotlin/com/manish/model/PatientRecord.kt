package com.manish.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

data class PatientRecord(
        var patientId : Patient,
        var records : MutableList<Appointment>
){}