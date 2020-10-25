package day2

open class L0 {
    val x = 10

    fun method1()
    {
        println("Level 0")
    }
}

class L1 : L0() {

    fun print() {
        println("Value of X " + x)
    }

}

fun main(args: Array<String>) {
    val obj = L1()
    obj.method1()
    obj.print()
}