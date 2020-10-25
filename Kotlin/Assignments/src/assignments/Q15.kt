package assignments

//Create a calculator methods (add,sub.mul&div)  in companion object.
// Made this methods available for other classes. Demonstrate how we can invoke these methods from a given class.

class Calculator{
    companion object{
        fun add(operand1 : Int , operand2 : Int )
        {
            println("Sum = ${operand1 + operand2}")
        }
        fun sub(operand1 : Int , operand2 : Int )
        {
            println("Difference = ${operand1 - operand2}")
        }
        fun mul(operand1 : Int , operand2 : Int )
        {
            println("Product = ${operand1 * operand2}")
        }
        fun div(operand1 : Int , operand2 : Int )
        {
            println("Quotient = ${operand1 / operand2}")
        }
    }
}

fun main()
{
    Calculator.add(1,2)
    Calculator.sub(1,2)
    Calculator.mul(1,2)
    Calculator.div(1,2)
}