package assignments

class Account1{
    var accountID:Int
    var accType:String
    var accName:String

    constructor(accID : Int , type : String , name : String){
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
    var obj1 = Account1(100,"Savings","Ramesh")
    var obj2 = Account1(101,"Savings","Rakesh")
    var obj3 = Account1(102,"Current","Rahul")
    var obj4 = Account1(103,"Savings","Ram")
    var obj5 = Account1(104,"Current","Lakshman")

    obj1.display()
    obj2.display()
    obj3.display()
    obj4.display()
    obj5.display()

}