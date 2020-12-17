package com.manish.exception

import com.manish.exception.AppointmentNotFoundException
import com.manish.exception.DoctorNotFoundException
import com.manish.exception.InvalidAppointmentCategoryException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime


@ControllerAdvice
class PamsResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {


    @ExceptionHandler(DoctorNotFoundException::class)
    fun doctorNotFound(exception: DoctorNotFoundException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(AppointmentNotFoundException::class)
    fun appointmentNotFound(exception: AppointmentNotFoundException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(DepartmentNotFoundException::class)
    fun departmentNotFound(exception: DepartmentNotFoundException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(PatientNotFoundException::class)
    fun patientNotFound(exception: PatientNotFoundException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFound(exception: UserNotFoundException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(InvalidAppointmentCategoryException::class)
    fun invalidCategory(exception: InvalidAppointmentCategoryException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(InvalidUserDataException::class)
    fun invalidUserData(exception: InvalidUserDataException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(InvalidDateFormatException::class)
    fun invalidDateFormat(exception: InvalidDateFormatException): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(exception.message!!, LocalDateTime.now())
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}