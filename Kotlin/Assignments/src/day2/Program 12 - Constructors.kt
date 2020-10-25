package day2

class SecondConst2{

    constructor(name: String, id: Int,pass: String){
        println("Called Secondary Constructor")
        println("Name = $name")
        println("Id = $id")
        println("Password = $pass")
    }

    constructor(name: String, id: Int): this(name,id, "pass1425"){
        println("Calling Secondary Constructor")
    }


}
fun main(args: Array<String>){
    val myclass = SecondConst2("Rishab", 105)
}