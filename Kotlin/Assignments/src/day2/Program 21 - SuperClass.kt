package day2

open class Bird1 {
    open var color = "Black"
    open fun fly() {
        println("Bird is flying...")
    }
}
class Parrot1: Bird1() {
    override var color = "Green"
    override fun fly() {
        super.fly()
        println("Parrot is flying...")
    }
}

fun main(args: Array<String>) {
    val p = Parrot1()
    p.fly()
    println(p.color)

}