package assignments

tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) {
        run.toLong()
    } else {
        factorial(n - 1, run * n)
    }
}
fun main(args: Array<String>) {
    var result = factorial(5)
    println("Factorial = $result")
}

