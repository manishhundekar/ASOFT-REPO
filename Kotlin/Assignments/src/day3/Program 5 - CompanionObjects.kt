package day3

class MyClass {
    companion object {
        fun create(){
            println("calls create method of companion object (just like static method in JAVA)")
        }
        var pi = 3.14
    }
}
fun main(){
    MyClass.create()
    println(MyClass.pi)
}  