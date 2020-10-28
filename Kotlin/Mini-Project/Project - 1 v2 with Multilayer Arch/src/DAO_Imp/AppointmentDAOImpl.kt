package DAO_Imp

import DAO.AppointmentDAO
import model.Appointment
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation
import java.sql.ResultSet
import java.sql.SQLIntegrityConstraintViolationException
import java.sql.PreparedStatement

class AppointmentDAOImpl : AppointmentDAO{
    var dbConnect = DBConnect()
    override fun viewAllAppointments()
    {
        dbConnect.getConnection()
        val sql = "SELECT a.APP_ID,a.APP_DATE,p.PATIENT_NAME,d.DOC_NAME,a.CATEGORY,a.DESCRIPTION,a.STATUS FROM appointment a,patient p , doctor d where a.PAT_ID=p.PID AND a.DOC_ID=d.DOC_ID ORDER BY a.APP_ID"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        println("-------------------------------------------------------------")
        while(resultSet?.next()!!)
        {

            println("Appointment ID : ${resultSet?.getInt(1)} \tDate : ${resultSet.getString(2)} \t" +
                    "Patient Name : ${resultSet.getString(3)} \tDoctor Name : ${resultSet.getString(4)} , \t" +
                    "Category : ${resultSet.getString(5)} \t" + "Description : ${resultSet.getString(6)}" +
                    "\tStatus : ${resultSet.getString(7)}" );
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }

    //fun newAppointment(date: String?, pid: Int?, did: Int?, cate: String, descrp: String?)
    override fun newAppointment(appointment: Appointment) {
        dbConnect.getConnection()
        try{
            val sql = "INSERT INTO appointment(APP_DATE,PAT_ID,DOC_ID,CATEGORY,DESCRIPTION) VALUES(?,?,?,?,?)"
            val statement: PreparedStatement? = conn?.prepareStatement(sql)
            if (statement != null) {
                statement.setString(1 , appointment.appDate)
                statement.setInt(2 , appointment.patID)
                statement.setInt(3 , appointment.docID)
                statement.setString(4 , appointment.category)
                statement.setString(5 , appointment.description)
                if(statement.executeUpdate()>0)
                {
                    println("APPOINTMENT SUCCESSFULL")
                }
                else
                {
                    println("APPOINTMENT UNSUCCESSFULL")
                }
            }
        }catch (e : SQLIntegrityConstraintViolationException)
        {
            // e.printStackTrace()
            println("INVALID PATIENT/DOCTOR ID")
        }
        catch (e : MysqlDataTruncation)
        {
            //e.printStackTrace()
            println("INVALID DATE FORMAT \nSHOULD BE IN YYYY-MM-DD FORMAT ONLY")
        }
        finally {
            dbConnect.closeConnection()
        }
    }

    override fun upcomingAppointmentsByDoctor(did: Int?)
    {
        dbConnect.getConnection()
        val sql = "SELECT a.APP_ID,a.APP_DATE,p.PATIENT_NAME,d.DOC_NAME,a.CATEGORY,a.DESCRIPTION,a.STATUS FROM appointment a , patient p , doctor d where a.DOC_ID = ${did} AND p.PID=a.PAT_ID AND d.DOC_ID=a.DOC_ID AND a.APP_DATE> CURDATE()"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("Appointment ID : ${resultSet?.getInt(1)} \tDate : ${resultSet.getString(2)} \t" +
                    "Patient Name : ${resultSet.getString(3)} \tDoctor Name : ${resultSet.getString(4)} , \t" +
                    "Category : ${resultSet.getString(5)} \t" + "Description : ${resultSet.getString(6)}" +
                    "\tStatus : ${resultSet.getString(7)}" );
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }

    override fun upcomingAppointments()
    {
        dbConnect.getConnection()
        val sql = "SELECT a.APP_ID,a.APP_DATE,p.PATIENT_NAME,d.DOC_NAME,a.CATEGORY,a.DESCRIPTION,a.STATUS FROM appointment a , patient p , doctor d where p.PID=a.PAT_ID AND d.DOC_ID=a.DOC_ID AND a.APP_DATE> CURDATE() AND a.STATUS!='Cancelled'"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("-------------------------------------------------------------")
            println("Appointment ID : ${resultSet?.getInt(1)} \tDate : ${resultSet.getString(2)} \t" +
                    "Patient Name : ${resultSet.getString(3)} \tDoctor Name : ${resultSet.getString(4)} , \t" +
                    "Category : ${resultSet.getString(5)} \t" + "Description : ${resultSet.getString(6)}" +
                    "\tStatus : ${resultSet.getString(7)}" );
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }


    override fun cancelAppointment(aid: Int?)
    {
        dbConnect.getConnection()
        try {
            val sql = "UPDATE appointment SET STATUS = 'CANCELLED' where APP_ID = ? "
            val statement= conn?.prepareStatement(sql)
            statement?.setInt(1, aid!!)
            if(statement?.executeUpdate()!! >0)
            {
                println("APPOINTMENT CANCELLED SUCCESSFULL")
            }else
            {
                println("APPOINTMENT CANCEL UNSUCCESSFULL")
            }

        }catch (e : Exception )
        {
            e.printStackTrace()
        }
        finally {
            dbConnect.closeConnection()
        }
    }

    override fun appointmentStatus(aid : Int?)
    {
        dbConnect.getConnection()
        val sql = "SELECT APP_ID,APP_DATE,STATUS FROM appointment WHERE APP_ID = ${aid}"
        val statement= conn?.createStatement()
        var resultSet: ResultSet? = statement?.executeQuery(sql)
        while(resultSet?.next()!!)
        {
            println("-------------------------------------------------------------")
            println("Appointment ID : ${resultSet.getInt(1)} \tDate : ${resultSet.getString(2)} \t" +
                    "Status : ${resultSet.getString(3)} " );
            println("-------------------------------------------------------------")
        }
        dbConnect.closeConnection()
    }
}