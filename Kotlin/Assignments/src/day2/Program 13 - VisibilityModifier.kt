package day2

//By Default Public - Visible to everyone

public class publicClass{

    public var name : String = "Shree" ;
    var age : Int = 22 ;
}

fun main() {
    var obj = publicClass()
    println("Name : " + obj.name)
    print("Age : " + obj.age)
}