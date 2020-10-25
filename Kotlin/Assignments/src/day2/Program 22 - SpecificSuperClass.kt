package day2

open class Bird2 {
    open var color = "Black"
    open fun fly() {
        println("Bird is flying...")
    }
}

interface Duck2 {
    fun fly() {
        println("Duck is flying...")
    }
}

class Parrot2 : Bird2(), Duck2 {
    override var color = "Green"
    override fun fly() {
        super<Bird2>.fly()
        super<Duck2>.fly()
        println("Parrot is flying...")

    }
}

fun main(args: Array<String>) {
    val p = Parrot2()
    p.fly()
    println(p.color)

}