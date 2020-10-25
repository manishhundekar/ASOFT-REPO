package day1

/*
Type Conversion:
toByte()
toShort()
toInt()
toLong()
toFloat()
toDouble()
toChar()
 */

fun main(args : Array<String>)
{
    var intnumber = 10;
    //var floatnumber : Float = intnumber; // TYPE MISMATCH ERROR
    var floatnumber : Float = intnumber.toFloat();
    println("Integer Number : $intnumber \nFloat Number : $floatnumber")
}