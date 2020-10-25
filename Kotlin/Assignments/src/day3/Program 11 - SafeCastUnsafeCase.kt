package day3

fun main() {
    var location: Any = "Manipal"
    val unsafe: String? = location as String
    println("Unsafe Done Successfully - Value : $unsafe")

    val safeString:String? = location as? String
    println("Safe String Done Successfully - Value : $safeString")

    val safeInt:Int? = location as? Int
    println("Safe Int Done Successfully - Value : $safeInt")
}