package project.dao

import java.sql.*

fun DAO_viewAllDoc()
{
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
}

fun DAO_addDoctor(name: String?, did: Int?, qual: String?, add: String?, phn: String?, email: String?, doj: String?)
{
    val sql = "INSERT INTO doctor(DOC_NAME,DEPT_NO,QUALIFICATION,ADDRESS,PHONE,EMAIL,DOJ) VALUES(?,?,?,?,?,?,?)"
    val statement: PreparedStatement? = conn?.prepareStatement(sql)
    if (statement != null) {
        statement.setString(1 , name)
        statement.setInt(2 , did!!)
        statement.setString(3 , qual)
        statement.setString(4 , add)
        statement.setString(5 , phn)
        statement.setString(6 , email)
        statement.setString(7 , doj)
        if(statement.executeUpdate()>0)
        {
            println("DOCTOR ADD SUCCESSFULL")
        }
        else
        {
            println("DOCTOR ADD UNSUCCESSFULL")
        }
    }
}

fun DAO_searchDoctorByID(did: Int?)
{
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
}

fun DAO_searchDoctorByName(dname : String?)
{
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
}

fun DAO_updateDoctorName(did: Int?, dname: String?) {
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
}

fun DAO_updateDoctorQual(did: Int?, dqual: String?) {
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
}

fun DAO_updateDoctorPhone(did: Int?, dph: String?) {
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
}

fun DAO_updateDoctorEmail(did: Int?, demail: String?) {
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
}


fun DAO_deleteDoctor(did : Int?)
{
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
}