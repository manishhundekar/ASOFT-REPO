package day2

fun main(args: Array<String>) {
    val array1 = arrayOf(1, 2, 3, 4)
    val array2 = arrayOf<Long>(11, 12, 13, 14)
    array2.set(2, 10)
    array2[3] = 8
    for (element in array2) {
        println(element)
    }
}