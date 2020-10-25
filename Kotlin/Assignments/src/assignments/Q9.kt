package assignments

//9. Create a class called Account with acctid,Acct_type,name with primary constructor.
//Create 5 instance to Account class to display each ones details.

class Account(accID : Int , type : String , name : String){
    var accountID:Int
    var accType:String
    var accName:String

    init {
        accountID = accID
        accType = type
        accName = name
    }

    fun display()
    {
        println("Account ID : $accountID \nAccount Type : $accType \nAccount Name : $accName")
    }

}

fun main()
{
    var obj1 = Account(100,"Savings","Ramesh")
    var obj2 = Account(101,"Savings","Rakesh")
    var obj3 = Account(102,"Current","Rahul")
    var obj4 = Account(103,"Savings","Ram")
    var obj5 = Account(104,"Current","Lakshman")

    obj1.display()
    obj2.display()
    obj3.display()
    obj4.display()
    obj5.display()

}