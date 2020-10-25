package project.dao

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLIntegrityConstraintViolationException

fun DAO_viewAllAppointments()
{
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
}

fun DAO_newAppointment(date: String?, pid: Int?, did: Int?, cate: String, descrp: String?) {
    try{
        val sql = "INSERT INTO appointment(APP_DATE,PAT_ID,DOC_ID,CATEGORY,DESCRIPTION) VALUES(?,?,?,?,?)"
        val statement: PreparedStatement? = conn?.prepareStatement(sql)
        if (statement != null) {
            statement.setString(1 , date)
            statement.setInt(2 , pid!!)
            statement.setInt(3 , did!!)
            statement.setString(4 , cate)
            statement.setString(5 , descrp)
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
}

fun DAO_upcomingAppointmentsByDoctor(did: Int?)
{
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
}

fun DAO_upcomingAppointmentsByDate()
{
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
}


fun DAO_cancelAppointment(aid: Int?)
{
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
}

fun DAO_appointmentStatus(aid : Int?)
{
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
}