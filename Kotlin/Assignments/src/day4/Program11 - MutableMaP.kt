package day4

fun main()
{
    val myMap1= mutableMapOf<Int,String>(1 to "Rahul Dravid", 2 to "Sachin Tendulkar")
    val myMap2:MutableMap<String,String> = mutableMapOf<String,String>("one" to "Rahul Dravid", "two" to "Raju Sharma")

    val myMap3:MutableMap<Any,Any> = mutableMapOf<Any,Any>()
    myMap3.putAll(myMap2)

    for(key in myMap1.keys)
    {
        println("Key : $key \tValue : ${myMap1[key]} ")
    }
    for(key in myMap2.keys)
    {
        println("Key : $key \tValue : ${myMap2[key]} ")
    }
    for(key in myMap3.keys)
    {
        println("Key : $key \tValue : ${myMap3[key]} ")
    }
}