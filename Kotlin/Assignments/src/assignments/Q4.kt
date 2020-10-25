package assignments

//Accept the age and weight of a person from console input,
// check whether the person is eligible to donate blood. If his age>18 and weight>55 he is eligible to donate blood

import java.util.*

fun main() {
    println("Enter Age")
    var sc = Scanner(System.`in`)
    var age= sc.nextInt();
    println("Enter Weight")
    var weight = sc.nextInt();
    if (age>18 && weight>55)
        print("The Person is eligible to donate blood")
    else
        print("The Person is not eligible to donate blood")
}