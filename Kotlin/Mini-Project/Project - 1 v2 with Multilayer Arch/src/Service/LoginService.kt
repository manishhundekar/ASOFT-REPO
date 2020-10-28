package Service

import DAO_Imp.LoginDAO

class LoginService {
    fun validateCred(username : String?, password : String?) : Boolean
    {
        var loginDAO = LoginDAO()
        return loginDAO.validateCredDAO(username, password)
    }
}
