package project.dao

import java.sql.ResultSet

fun validateCred(username: String?, password: String?) : Boolean
{
    try{
        getConnection()
        val sql = "SELECT * FROM admin WHERE username = '$username' AND password = '$password'"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        if(resultSet?.next()!!)
        {
            println("Login Successfull")
            return true
        }
        println("Invalid Credentials...Please try again")
        return false
        }catch(e : Exception)
        {
            e.printStackTrace()
            println("DB Error")
        }finally {
            closeConnection()
        }
        return false
}