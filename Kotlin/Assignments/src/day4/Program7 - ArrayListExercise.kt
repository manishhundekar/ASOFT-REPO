package day4
import java.util.Scanner

class Employee(var eId:Int, var eName:String, var eCity:String, var eSlary:Float)
fun main()
{

    var emplist:ArrayList<Employee> = arrayListOf<Employee>()
    var sc = Scanner(System.`in`)
    println("Enter the Number of Employees")
    var n = sc.nextInt();
    for(i in 0..n)
    {
        println("Enter the Employee ID")
        var id = sc.nextInt()
        println("Enter the Employee Name")
        var name = sc.next()
        println("Enter the Employee City")
        var city = sc.next()
        println("Enter the Employee Salary")
        var sal = sc.nextFloat()
        emplist.add(Employee(id,name,city,sal))
    }
    for(e in emplist)
    {
        println("${e.eId}, ${e.eName}, ${e.eCity}, ${e.eSlary}")
    }
}