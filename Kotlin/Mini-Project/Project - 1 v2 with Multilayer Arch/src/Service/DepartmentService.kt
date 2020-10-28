package Service

import DAO_Imp.DepartmentDAOImpl

class DepartmentService {
    var departmentDAO = DepartmentDAOImpl()

    fun addDept(dName: String) {
        departmentDAO.addDept(dName)
    }

    fun listDept() {
        departmentDAO.listDept()
    }

    fun delDept(did: String?) {
        departmentDAO.delDept(did)
    }

    fun updateDeptName(did: Int?, dname: String?) {
        departmentDAO.updateDeptName(did, dname)
    }

}