package day2

class account {
    var acc_no: Int = 0
    var name: String = ""
    var amount: Float = 0f

    fun input(ano : Int , name : String , amount : Float) {
        acc_no = ano
        this.name = name
        this.amount = amount
    }

    fun output() {
        println("Account No : $acc_no \nName : $name \nAmount : $amount")
    }
}

fun main()
{
    var acc1 = account()
    acc1.input(123,"Ramesh",1425f)
    acc1.output()
}