package day2

fun example(name:String, age : String ,fn:(String,String)->String)
{
 println(fn(name,age))
}

fun main(args : Array<String>)
{
    val fn:(String,String) -> String = { name , age ->  name + " is " + age + " years old"}
    example("Manish","22",fn)
}