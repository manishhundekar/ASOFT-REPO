package day2

fun main(args:Array<String>)
{
    var array1 = arrayOf(1,"Hero","Heroine","Director","Producer")
    for(item in array1)
    {
        println(item)
    }
    //SET
    array1.set(0,"Comedian")
    for(item in array1)
    {
        println(item)
    }
    //GET
    println(array1.get(0))
}