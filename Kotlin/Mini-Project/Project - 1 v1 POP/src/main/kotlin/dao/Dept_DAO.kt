package project.dao

import java.sql.PreparedStatement
import java.sql.ResultSet


fun DAO_newDept(name : String)
{
    val sql = "INSERT INTO department(DEPT_NAME) VALUES(?)"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    if (statement != null) {
        statement.setString(1 , name)
        if(statement.executeUpdate()>0)
        {
            println("INSERTION SUCCESSFULL")
        }
        else
        {
            println("INSERTION UNSUCCESSFULL")
        }
    }
}

fun DAO_viewDept()
{
    val sql = "SELECT * from department order by DEPT_ID"
    val statement= conn?.createStatement()
    var resultSet:ResultSet? = statement?.executeQuery(sql)
    println("-------------------------------------------------------------")
    while(resultSet?.next()!!)
    {
        println("Department ID : " + resultSet.getInt(1) + "\tDepartment Name : " + resultSet.getString(2));
        println("-------------------------------------------------------------")
    }
}

fun DAO_delDept(id: String?)
{
    try {
        val sql = "DELETE from department where DEPT_ID = ? "
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,id)
        if(statement?.executeUpdate()!! >0)
        {
            println("DELETION SUCCESSFULL")
        }else
        {
            println("DELETION UNSUCCESSFULL")
        }

    }catch (e : Exception )
    {
        e.printStackTrace()
    }
}

fun DAO_updateDeptName(did: Int?, dname: String?)
{
    try {
        val sql = "UPDATE department SET DEPT_NAME = ? where DEPT_ID = ? "
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,dname)
        statement?.setInt(2, did!!)
        if(statement?.executeUpdate()!! >0)
        {
            println("UPDATE SUCCESSFULL")
        }else
        {
            println("UPDATE UNSUCCESSFULL")
        }

    }catch (e : Exception )
    {
        e.printStackTrace()
    }
}