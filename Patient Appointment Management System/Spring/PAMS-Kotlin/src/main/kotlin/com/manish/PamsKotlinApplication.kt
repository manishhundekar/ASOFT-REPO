package com.manish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.CrossOrigin

//@EntityScan("model.*")
//@ComponentScan("")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@SpringBootApplication
class PamsKotlinApplication

fun main(args: Array<String>) {
	runApplication<PamsKotlinApplication>(*args)
}
