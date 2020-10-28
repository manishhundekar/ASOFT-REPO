package DAO

interface DepartmentDAO {
    fun addDept(name : String)
    fun listDept()
    fun delDept(id: String?)
    fun updateDeptName(did: Int?, dname: String?)

}