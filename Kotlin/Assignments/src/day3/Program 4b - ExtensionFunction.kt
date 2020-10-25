package day3

class Vehicle2{
    fun run(): String {
        return "It's Running"
    }
}

//Extended Method
fun Vehicle2.stop() : String
{
    return "It's Not Running"
}

fun Vehicle2.stop(name : String) : String
{
    return "It's Not Running"
}

fun main()
{
    var vehicle = Vehicle2()
    println(vehicle.run())
    println(vehicle.stop())
}