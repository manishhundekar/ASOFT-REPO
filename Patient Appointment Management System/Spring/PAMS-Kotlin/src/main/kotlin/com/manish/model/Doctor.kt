package com.manish.model

import javax.persistence.*

@Entity
@Table(name = "doctor")
data class Doctor (
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
         var doctorId : Int ,
         var doctorName:String ,
         var departmentNo : Int ,
         var qualification:String ,
         var address:String ,
         var phone:String ,
         var email:String,
         @Column(name = "status", nullable = false, columnDefinition = "int default 1",insertable = false)
         var status:Int = 1
        //,var doj:String
        ) {}

/*
data class Doctor (var docID:Int , var docName:String , var deptNo : Int , var qual:String ,
                   var address:String , var phone:String , var email:String , var doj:String) {

}
*/