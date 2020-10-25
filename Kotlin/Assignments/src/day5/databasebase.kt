package day5

import java.sql.DriverManager


fun main(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root")
        var statement = connection.createStatement()
        var resultSet = statement.executeQuery("SELECT * FROM actor")
        while(resultSet.next())
        {
            println(" ${resultSet.getInt(1)} \t  + ${resultSet.getString("first_name")} ")
        }
    }catch (e : Exception)
    {
        e.printStackTrace()
    }

}