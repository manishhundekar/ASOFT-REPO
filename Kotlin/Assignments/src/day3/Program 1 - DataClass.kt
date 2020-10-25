package day3

data class College( var CID : Int , var cName : String ,var cAddress : String  )

fun main()
{
    var college1 = College(1001,"GNDECB","Bidar");
    println(college1) // OBJECT CODE --> toString()
    println(college1.CID) //GETTERS
    println(college1.cName) //GETTERS
    println(college1.cAddress) //GETTERS

    //equals()
    //hashCode()
    // == comparision

    var college2 = College(1001,"GNDECB","Bidar");
    println(college1.equals(college2)) // True (False in case of normal class)
    println(college1 == college2) // comparing the object reference
    println(college1.hashCode())


    //copy()

    var college3 = college1.copy();
    print(college3)
}