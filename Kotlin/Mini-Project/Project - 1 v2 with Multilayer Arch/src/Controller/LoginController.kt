package Controller

import Service.LoginService
import java.sql.ResultSet

class LoginController
{
    fun initiateLogin() : Boolean{
        var loginService = LoginService();
        println("Enter Username :")
        var username = readLine()
        println("Enter Password :")
        var password = readLine()
        return loginService.validateCred(username, password)
    }

}