package day2

//The internal modifiers are newly added in Kotlin, it is not available in Java. Declaring anything makes that field marked as internal field.
// The internal modifier makes the field visible only inside the module in which it is implemented.

open class InternalExample {
    internal val i = 0
    internal fun print()
    {
       println("Inside print() $i")
    }
}


fun main() {
    var obj = InternalExample()
    println("Value : " + obj.print())
}