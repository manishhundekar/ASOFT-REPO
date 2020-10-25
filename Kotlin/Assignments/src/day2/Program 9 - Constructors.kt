package day2

class PrimaryConst(val name: String, var id: Int)
{

}

fun main(args: Array<String>){
    val obj1 = PrimaryConst("Suresh", 101)
    println("Name = $obj1.name")
    println("Id = $obj1.id")
}