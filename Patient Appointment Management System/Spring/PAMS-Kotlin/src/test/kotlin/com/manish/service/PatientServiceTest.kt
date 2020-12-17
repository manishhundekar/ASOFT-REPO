package com.manish.service

import com.manish.exception.DoctorNotFoundException
import com.manish.exception.PatientNotFoundException
import com.manish.model.Doctor
import com.manish.model.Patient
import com.manish.service.PatientService
import com.manish.repository.PatientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*


@SpringBootTest
class PatientServiceTest {

    @MockBean
    private var patientRepository: PatientRepository? = null

    //@InjectMocks
    @Autowired
    var patientService : PatientService? = null

    @BeforeEach
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun viewAllPatientsTest()
    {
        var patient1 : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        var patient2 : Patient = Patient(2,"Rahul",22,"Male","Hyderbad","8874157486","rahul@gmail.com","None",1)

        var patientList  = mutableListOf<Patient>()
        patientList.add(patient1)
        patientList.add(patient2)

        Mockito.`when`(patientRepository?.findAll()).thenReturn(patientList)
        val expected = patientList
        Assertions.assertEquals(expected, patientService?.viewAllPatients())
    }

    @Test
    fun viewPatientByIDTest()
    {
        var patient1 : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        var patient : Optional<Patient>? =  Optional.of(patient1)

        Mockito.`when`(patientRepository?.findById(1)).thenReturn(patient)
        val expected1 = patient1
        Assertions.assertEquals(expected1, patientService?.viewPatientByID(1))

        Mockito.`when`(patientRepository?.findById(100)).thenThrow(PatientNotFoundException("Invalid Patient ID ->100"))
        assertThrows<PatientNotFoundException> {  patientService?.viewPatientByID(100) }

    }

    @Test
    fun viewPatientByNameTest()
    {
        var patient1 : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        var patient : Optional<Patient>? =  Optional.of(patient1)

        Mockito.`when`(patientRepository?.findByName("Kumar")).thenReturn(patient)
        val expected1 = patient1
        Assertions.assertEquals(expected1, patientService?.viewPatientByName("Kumar"))

        Mockito.`when`(patientRepository?.findByName("Ramesh")).thenThrow(PatientNotFoundException("Invalid Patient Name ->Ramesh"))
        assertThrows<PatientNotFoundException> {  patientService?.viewPatientByName("Ramesh") }

    }

    @Test
    fun addPatientTest()
    {
        var patient : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        Mockito.`when`(patientRepository?.save(patient)).thenReturn(patient)
        val expected = patient
        Assertions.assertEquals(expected, patientService?.addPatient(patient))
    }

    @Test
    fun disablePatientTest()
    {
        var patient : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        Mockito.`when`(patientRepository?.save(patient)).thenReturn(patient)
        val expected = patient
        Assertions.assertEquals(expected, patientService?.disablePatient(patient))
    }


    @Test
    fun viewAllInPatientTest()
    {
        var patient1 : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        var patient2 : Patient = Patient(2,"Rahul",22,"Male","Hyderbad","8874157486","rahul@gmail.com","None",1)

        var patientList  = mutableListOf<Patient>()
        patientList.add(patient1)
        patientList.add(patient2)

        Mockito.`when`(patientRepository?.findByCategory("In-Patient")).thenReturn(patientList)
        val expected = patientList
        Assertions.assertEquals(expected, patientService?.viewAllInPatient())
    }

    @Test
    fun viewAllOutPatientTest()
    {
        var patient1 : Patient = Patient(1,"Kumar",25,"Male","Bangalore","7894157484","kumar@gmail.com","None",1)
        var patient2 : Patient = Patient(2,"Rahul",22,"Male","Hyderbad","8874157486","rahul@gmail.com","None",1)

        var patientList  = mutableListOf<Patient>()
        patientList.add(patient1)
        patientList.add(patient2)

        Mockito.`when`(patientRepository?.findByCategory("Out-Patient")).thenReturn(patientList)
        val expected = patientList
        Assertions.assertEquals(expected, patientService?.viewAllOutPatient())
    }
}
