package day3

fun main() {
    val stringList: ArrayList<String> = arrayListOf<String>("Banana", "Grapes", "Mango")
    val floatList: ArrayList<Float> = arrayListOf<Float>(12.4f, 45.2f, 56.7f)
    val mixedList: ArrayList<Any> = arrayListOf<Any>("Hello", "Welcome", 34, 56.2f, 78, "Hi", 'c')
    stringList.printList()
    floatList.printList()
    mixedList.printList()
}

fun  <T> ArrayList<T>.printList() {
    for (element in this) {
        print(element)
    }
}

