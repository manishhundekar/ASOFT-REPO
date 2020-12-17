package com.manish.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="user")
data class User (@Id var userId : Int, var userName : String, var password : String ,var status : Int = 1) {
}