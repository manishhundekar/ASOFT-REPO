package day2

//Protected - A protected modifier with class or interface allows visibility to its class or subclass only.
//A protected declaration (when overridden) in its subclass is also protected modifier unless it is explicitly changed.

open class Level0 {
    protected val i = 0
}

class Level1 : Level0() {

    fun getValue(): Int {
        return i
    }
}


fun main() {
    var obj = Level1()
    println("Value : " + obj.getValue())
}