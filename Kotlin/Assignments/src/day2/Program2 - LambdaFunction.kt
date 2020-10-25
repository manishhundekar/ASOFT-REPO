package day2

fun main(args : Array<String>)
{
    val myLambda = {s : String -> println(s)}
    welcomeName("Manish")
}

fun welcomeName( name : String )
{
    println("Welcome " + name)
}