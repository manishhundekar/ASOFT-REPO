package day3

fun main(args: Array<String>){
    var str: String? = "Hello World"
    val length = if(str != null) {str.length}else{0}
    //val length = (str != null) ? str.length : 0
    print("Length of the string is $length")
}