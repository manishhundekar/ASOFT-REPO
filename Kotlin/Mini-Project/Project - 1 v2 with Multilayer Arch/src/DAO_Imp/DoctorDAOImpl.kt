package DAO_Imp

import DAO.DoctorDAO
import model.Doctor
import java.sql.PreparedStatement
import java.sql.ResultSet

class DoctorDAOImpl : DoctorDAO {
    private var dbConnect = DBConnect()
    override fun listDoctors()
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM doctor ORDER BY DOC_ID"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("-------------------------------------------------------------")
            println("Doctor ID : ${resultSet.getInt(1)} \tDoctor Name : ${resultSet.getString(2)} \t" +
                    "Department ID : ${resultSet.getString(3)} \tQualification : ${resultSet.getString(4)}\t" +
                    "Address : ${resultSet.getString(5)} \t" + "Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \tDate of Joining : ${resultSet.getString(8)}" );
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }

    override fun addDoctor(doctor: Doctor)
    {
        dbConnect.getConnection()
        val sql = "INSERT INTO doctor(DOC_NAME,DEPT_NO,QUALIFICATION,ADDRESS,PHONE,EMAIL,DOJ) VALUES(?,?,?,?,?,?,?)"
        val statement: PreparedStatement? = conn?.prepareStatement(sql)
        if (statement != null) {
            statement.setString(1 ,doctor.docName)
            statement.setInt(2 , doctor.deptNo)
            statement.setString(3 , doctor.qual)
            statement.setString(4 , doctor.address)
            statement.setString(5 , doctor.phone)
            statement.setString(6 , doctor.email)
            statement.setString(7 , doctor.doj)
            if(statement.executeUpdate()>0)
            {
                println("DOCTOR ADD SUCCESSFUL")
            }
            else
            {
                println("DOCTOR ADD UNSUCCESSFUL")
            }
        }
        dbConnect.closeConnection()
    }

    override fun searchDoctorByID(did: Int?)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM doctor WHERE `DOC_ID` = ${did}"
        val statement= conn?.prepareStatement(sql)
        //statement?.setString(1,id)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Doctor ID : ${resultSet.getInt(1)} \tDoctor Name : ${resultSet.getString(2)} \t" +
                    "Department ID : ${resultSet.getString(3)} \tQualification : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + "Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \tDate of Joining : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }

    override fun searchDoctorByName(dname : String?)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM doctor WHERE `DOC_NAME` LIKE '${dname}'"
        val statement= conn?.prepareStatement(sql)
        //statement?.setString(1,id)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Doctor ID : ${resultSet.getInt(1)} \tDoctor Name : ${resultSet.getString(2)} \t" +
                    "Department ID : ${resultSet.getString(3)} \tQualification : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + "Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \tDate of Joining : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }

    override fun updateDoctorName(did: Int?, dname: String?) {
        dbConnect.getConnection()
        val sql = "UPDATE doctor SET DOC_NAME = ? WHERE DOC_ID = ?"
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,dname)
        statement?.setInt(2, did!!)
        if (statement != null) {
            if(statement.executeUpdate()>0) {
                println("UPDATE SUCCESSFULL")
            } else {
                println("UPDATE UNSUCCESSFULL")
            }
        }
        dbConnect.closeConnection()
    }

    override fun updateDoctorQual(did: Int?, dqual: String?) {
        dbConnect.getConnection()
        val sql = "UPDATE doctor SET QUALIFICATION = ? WHERE DOC_ID = ?"
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,dqual)
        statement?.setInt(2, did!!)
        if (statement != null) {
            if(statement.executeUpdate()>0) {
                println("UPDATE SUCCESSFULL")
            } else {
                println("UPDATE UNSUCCESSFULL")
            }
        }
        dbConnect.closeConnection()
    }

    override fun updateDoctorPhone(did: Int?, dph: String?) {
        dbConnect.getConnection()
        val sql = "UPDATE doctor SET PHONE = ? WHERE DOC_ID = ?"
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,dph)
        statement?.setInt(2, did!!)
        if (statement != null) {
            if(statement.executeUpdate()>0) {
                println("UPDATE SUCCESSFULL")
            } else {
                println("UPDATE UNSUCCESSFULL")
            }
        }
        dbConnect.closeConnection()
    }

    override fun updateDoctorEmail(did: Int?, demail: String?) {
        dbConnect.getConnection()
        val sql = "UPDATE doctor SET EMAIL = ? WHERE DOC_ID = ?"
        val statement= conn?.prepareStatement(sql)
        statement?.setString(1,demail)
        statement?.setInt(2, did!!)
        if (statement != null) {
            if(statement.executeUpdate()>0) {
                println("UPDATE SUCCESSFULL")
            } else {
                println("UPDATE UNSUCCESSFULL")
            }
        }
        dbConnect.closeConnection()
    }


    override fun deleteDoctor(did : Int?)
    {
        dbConnect.getConnection()
        try {
            val sql = "DELETE from doctor where DOC_ID = ? "
            val statement= conn?.prepareStatement(sql)
            statement?.setInt(1,did!!)
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
        finally {
            dbConnect.closeConnection()
        }
    }
}