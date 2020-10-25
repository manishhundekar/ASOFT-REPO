package day2

open class Employee(name: String, age: Int, salary: Float) {
}

class Developer(name: String, age: Int, salary: Float , city : String):Employee(name,age,salary){
    var nativeCity = city
    fun work() {
        println("Full Stack Development")
    }
}
class Manager(name: String, age: Int, salary: Float ,city : String):Employee(name,age,salary){
    var nativeCity = city
    fun work() {
        println("Travelling is my hobby.")
    }
}
fun main(args: Array<String>){
    val obj1 = Developer("Shreyas", 18, 45000f , "Bidar")
    obj1.work()
    val obj2 = Manager("Virat", 35, 30500f , "Bangalore")
    obj2.work()
}