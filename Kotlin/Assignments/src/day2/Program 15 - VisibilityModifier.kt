package day2

//Protected - Overriding

open class Level00 {
    open protected val i = 0
}

class Level01 : Level00() {

    override val i = 10
    fun getValue(): Int {
        return i
    }
}


fun main() {
    var obj = Level01()
    println("Value : " + obj.getValue())
}