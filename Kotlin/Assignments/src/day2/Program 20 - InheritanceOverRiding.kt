package day2

// Method and Property Overriding

open class Bird {
    open var color = "Brown"
    open fun fly() {
        println("Bird is flying...")
    }
}

class Parrot : Bird() {
    override var color = "Green"

    fun myColor():String {
        return color
    }

    override fun fly() {
        println("Parrot is flying...")
    }
}

class Duck : Bird() {
    override var color = "White"
    fun myColor():String {
        return color
    }

    override fun fly() {
        println("Duck is flying...")
    }
}

fun main(args: Array<String>) {
    val p = Parrot()
    p.fly()
    println("Color : ${p.myColor()}")
    val d = Duck()
    d.fly()
    println("Color : ${d.myColor()}")
}