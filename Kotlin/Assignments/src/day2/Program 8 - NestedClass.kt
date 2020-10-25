package day2

class outerClass {
    var name: String = "Ramesh"

    class innerClass {
        var id: Int = 101
        fun foo() {
            println("ID: $id")
        }
    }
}

fun main(args: Array<String>) {
    println(outerClass.innerClass().id)
    var obj = outerClass.innerClass()
    obj.foo()
}