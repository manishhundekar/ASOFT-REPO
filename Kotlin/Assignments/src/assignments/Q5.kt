package assignments

//5. Accept the business sales revenue of the employee as console input.
//If the revenue is in  below range provide bonus as follows
//10000-2000 bonus=1500
//21000-40000 bonus=2500
//41000-60000 bonus=3500
//Any other number “Not eligible for now”
// Use when operator to do this code

import java.util.*

fun main() {
    println("Enter Sales Revenue of the employee")
    var sc = Scanner(System.`in`)
    var rev = sc.nextFloat();
    var bonus = when (true) {
        rev>=10000 && rev<=20000 -> 1500
        rev>20000 && rev<=40000 -> 2500
        rev>40000 && rev<=60000 -> 3500
        else -> "Not Eligible for now"
    }
    println("Bonus : $bonus")
}