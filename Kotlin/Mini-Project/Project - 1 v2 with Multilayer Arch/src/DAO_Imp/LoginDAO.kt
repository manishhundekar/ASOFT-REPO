package DAO_Imp

import java.sql.ResultSet

class LoginDAO {
    var dbConnect = DBConnect()
    fun validateCredDAO(username: String?, password: String?): Boolean {
        try {
            dbConnect.getConnection()
            val sql = "SELECT * FROM admin WHERE username = '$username' AND password = '$password'"
            val statement = conn?.createStatement()
            var resultSet: ResultSet? = statement?.executeQuery(sql)
            if (resultSet?.next()!!) {
                println("Login Successfull")
                return true
            }
            println("Invalid Credentials...Please try again")
            return false
        } catch (e: Exception) {
            e.printStackTrace()
            println("DB Error")
        } finally {
            dbConnect.closeConnection()
        }
        return false
    }
}