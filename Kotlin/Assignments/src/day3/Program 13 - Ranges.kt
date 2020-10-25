package day3


fun main() {
    // 1 to 10
    for (r in 1..10) {
        print(r)
    }
    println()

    // Storing Range
    var r1 = 5.0..10.0
    println(r1)
    println("5.5 in range is ${5.5 in r1}")

    // Character Ranges
    for (c in 'a'..'z') {
        print(c)
    }
    println()

    //downTo, downTo() ,rangeTo() , step
    for (x in 10 downTo 1 step 2)
        print(x)
    println()

    for (x in 10.downTo(1)) {
        print(x)
    }
    println()
    for (x in 1.rangeTo(20) step 2) {
        print(x)
    }
    println()

    //Iterators
    val tmp = (1..50)
    val it = tmp.iterator()
    while (it.hasNext()) {
        print("${it.next()}")
    }
}