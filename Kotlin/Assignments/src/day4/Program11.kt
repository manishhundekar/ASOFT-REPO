package day4


fun main()
{
    val myMap1:HashMap<Int,String> = hashMapOf<Int,String>(1 to "Ravi", 2 to "Raju")
    val myMap2:HashMap<Any,Any> = hashMapOf<Any,Any>(1 to "Ravi", "eId" to 100, 'c' to "Raju")

    myMap1.put(3,"Sachin Tendulkar")
    myMap1.put(4,"Rahul Dravid")

    //Print using for-each
    for(item in myMap1)
    {
        print(" $item ")
    }

    //Keys
    for(key in myMap1.keys)
    {
        println("Key : $key \tValue : ${myMap1[key]} ")
    }

}