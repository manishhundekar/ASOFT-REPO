package assignments

//check whether the value 64.5 is present in the range,
import java.util.*

fun main() {
    println("Enter Start Range")
    var sc = Scanner(System.`in`)
    var startrange= sc.nextFloat();
    println("Enter End Range")
    var endrange = sc.nextFloat();
    if (64.5 in startrange..endrange)
        print("64.5 is Present between the given range")
    else
        print("64.5 is not present between the given range")
}