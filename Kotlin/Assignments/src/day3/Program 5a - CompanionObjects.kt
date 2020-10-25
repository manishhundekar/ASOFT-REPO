class MyClass {
    companion object {
        fun create() {
            println( "calling create method of companion object")
        }
    }
}
fun MyClass.Companion.helloWorld() {
    println("executing extension of companion object")
}
fun main() {
    MyClass.create() // Static Method
    MyClass.helloWorld() //Extended Static Method
}