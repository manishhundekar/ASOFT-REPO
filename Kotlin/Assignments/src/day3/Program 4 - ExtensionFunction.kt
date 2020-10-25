package day3

class Vehicle{
    fun run(): String {
        return "It's Running"
    }
}

//Extended Method
fun Vehicle.stop() : String
{
    return "It's Not Running"
}


fun main()
{
    var vehicle = Vehicle()
    println(vehicle.run())
    println(vehicle.stop())
}