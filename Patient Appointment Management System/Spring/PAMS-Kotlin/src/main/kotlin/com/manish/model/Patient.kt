package com.manish.model

import javax.persistence.*

@Entity
@Table(name="patient")
data class Patient (
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
         var pId:Int ,
         var name:String ,
         var age : Int ,
         var gender:String ,
         var address:String ,
         var phone:String ,
         var email:String ,
         var medHistory:String,
         @Column(columnDefinition = "int default 1")
         var status:Int = 1
) {}

/*data class Patient (var pID:Int , var pName:String , var pAge : Int , var pGender:String ,
                    var pAddress:String , var pPhone:String , var pEmail:String , var pMedHistory:String) {

}*/