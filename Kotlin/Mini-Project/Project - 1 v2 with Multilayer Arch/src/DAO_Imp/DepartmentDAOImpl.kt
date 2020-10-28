package DAO_Imp

import DAO.DepartmentDAO
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLIntegrityConstraintViolationException

class DepartmentDAOImpl : DepartmentDAO {

    var dbConnect = DBConnect()

    override fun addDept(name : String)
    {
        dbConnect.getConnection()
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
        dbConnect.closeConnection()
    }

    override fun listDept()
    {
        dbConnect.getConnection()
        val sql = "SELECT * from department order by DEPT_ID"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        println("-------------------------------------------------------------")
        while(resultSet?.next()!!)
        {
            println("Department ID : " + resultSet.getInt(1) + "\tDepartment Name : " + resultSet.getString(2));
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }

    override fun delDept(id: String?)
    {
        dbConnect.getConnection()
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

        }catch(e : SQLIntegrityConstraintViolationException)
        {
            println("Department Can't be Deleted : The Selected Department is linked with other Entitites..\n ")
        }
        catch (e : Exception )
        {
            println("DB Error")
            //e.printStackTrace()
        }
        dbConnect.closeConnection()
    }

    override fun updateDeptName(did: Int?, dname: String?)
    {
        dbConnect.getConnection()
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
        dbConnect.closeConnection()
    }
}