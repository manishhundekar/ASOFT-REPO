package day2

//The internal modifiers are newly added in Kotlin, it is not available in Java. Declaring anything makes that field marked as internal field.
// The internal modifier makes the field visible only inside the module in which it is implemented.

class PrivateExample {
    private val i = 0
    fun getValue():Int
    {
       return i
    }
}


fun main() {
    var obj = PrivateExample()
    println("Value : " + obj.getValue())
   // println("Value outside the class: " + obj.i)
}