package DAO_Imp

import DAO.PatientDAO
import model.Patient
import java.sql.PreparedStatement
import java.sql.ResultSet

class PatientDAOImpl : PatientDAO {
    var dbConnect = DBConnect()
    override fun addPatient(patient : Patient)
    {
        dbConnect.getConnection()
        val sql = "INSERT INTO patient(PATIENT_NAME,AGE,GENDER,ADDRESS,PHONE,EMAIL,MED_HISTORY) VALUES(?,?,?,?,?,?,?)"
        val statement: PreparedStatement? = conn?.prepareStatement(sql)
        if (statement != null) {
            statement.setString(1 , patient.name)
            statement.setInt(2 , patient.age)
            statement.setString(3 , patient.gender)
            statement.setString(4 , patient.address)
            statement.setString(5 , patient.phone)
            statement.setString(6 , patient.email)
            statement.setString(7 , patient.medHistory)
            if(statement.executeUpdate()>0)
            {
                println("PATIENT ADD SUCCESSFULL")
            }
            else
            {
                println("PATIENT ADD UNSUCCESSFULL")
            }
        }
        dbConnect.closeConnection()
    }

    override fun searchPatientByID(id: Int?)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM patient WHERE `PID` = ${id}"
        val statement= conn?.prepareStatement(sql)
        //statement?.setString(1,id)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \t Gender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + " Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \t Medical History : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }

    override fun searchPatientByName(name: String)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM patient WHERE PATIENT_NAME LIKE '${name}'"
        val statement= conn?.prepareStatement(sql)
        //statement?.setString(1,name)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \t Gender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + " Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \t Medical History : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }

    override fun updatePatientName(did: Int?, dname: String?)
    {
        dbConnect.getConnection()
        val sql = "UPDATE patient SET PATIENT_NAME = ? WHERE PID = ?"
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

    override fun updatePatientAge(did: Int?, dage: Int?)
    {
        dbConnect.getConnection()
        val sql = "UPDATE patient SET AGE = ? WHERE PID = ?"
        val statement= conn?.prepareStatement(sql)
        statement?.setInt(1,dage!!)
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

    override fun updatePatientPhone(did: Int?, dph: String?)
    {
        dbConnect.getConnection()
        val sql = "UPDATE patient SET PHONE = ? WHERE PID = ?"
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

    override fun updatePatientEmail(did: Int?, demail: String?)
    {
        dbConnect.getConnection()
        val sql = "UPDATE patient SET EMAIL = ? WHERE PID = ?"
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

    override fun deletePatient(id: Int?)
    {
        dbConnect.getConnection()
        try {
            val sql = "DELETE from patient where PID = ? "
            val statement= conn?.prepareStatement(sql)
            statement?.setInt(1,id!!)
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
        }finally {
            dbConnect.closeConnection()
        }
    }

    override fun searchRecordById(pid : Int)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM patient WHERE PID = ${pid}"
        val statement= conn?.prepareStatement(sql)
        //statement?.setInt(1,pid)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \t Gender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + " Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \t Medical History : ${resultSet.getString(8)}" );
        }

        println("------Recent Appointments-------")
        val sql1 = "SELECT * FROM appointment WHERE PAT_ID = ${pid}"
        val statement1= conn?.prepareStatement(sql1)
        // statement1?.setInt(1,pid)
        var resultSet1: ResultSet? = statement1?.executeQuery(sql1)
        while(resultSet1?.next()!!)
        {
            println("Patient ID : ${resultSet1.getInt("APP_ID")} \tDate : ${resultSet1.getString("APP_DATE")} \t" +
                    "Category : ${resultSet1.getString("CATEGORY")} \t Description : ${resultSet1.getString("DESCRIPTION")} ")
        }
        dbConnect.closeConnection()
    }

    override fun searchRecordByName(pname : String)
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM patient WHERE PATIENT_NAME LIKE '${pname}'"
        val statement= conn?.prepareStatement(sql)
        //statement?.setString(1,pname)
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \t Gender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + " Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \t Medical History : ${resultSet.getString(8)}" );
        }

        println("------Recent Appointments-------")
        val sql1 = "SELECT a.* FROM appointment a , patient p WHERE a.PAT_ID=p.PID AND PATIENT_NAME LIKE '${pname}'"
        val statement1= conn?.prepareStatement(sql1)
        //statement1?.setString(1,pname)
        var resultSet1: ResultSet? = statement1?.executeQuery(sql1)
        while(resultSet1?.next()!!)
        {
            println("Patient ID : ${resultSet1.getInt("APP_ID")} \tDate : ${resultSet1.getString("APP_DATE")} \t" +
                    "Category : ${resultSet1.getString("CATEGORY")} \t Description : ${resultSet1.getString("DESCRIPTION")} ")
        }
        dbConnect.closeConnection()
    }

    override fun showAdmittedPat()
    {
        dbConnect.getConnection()
        val sql = "SELECT p.* FROM patient p , appointment a WHERE CATEGORY = 'Admitted' AND a.PAT_ID=p.PID"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \t Gender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + " Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \t Medical History : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }

    override fun listPatients()
    {
        dbConnect.getConnection()
        val sql = "SELECT * FROM patient ORDER BY PID"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Patient ID : ${resultSet.getInt(1)} \tPatient Name : ${resultSet.getString(2)} \t" +
                    "Age : ${resultSet.getString(3)} \tGender : ${resultSet.getString(4)} , \t" +
                    "Address : ${resultSet.getString(5)} \t" + "Phone : ${resultSet.getString(6)} \t" +
                    "Email : ${resultSet.getString(7)} \tMedical History : ${resultSet.getString(8)}" );
        }
        dbConnect.closeConnection()
    }
}