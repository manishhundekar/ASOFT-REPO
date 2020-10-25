package day4


fun main()
{
    var list1:List<Int> = listOf<Int>(34,56,78,89,23,45)
    var list2:List<String> = listOf<String>("Delhi","Mumbai","Bangalore","Chennai")
    var list3:List<Any> = listOf<Any>(12,34,56.6 ,"Delhi","Mumbai","Bangalore","Chennai",false,'a')
    for(i in list1)
    {
        print(" " + i)
    }
    println()

    for(i in list2)
    {
        print(" " + i)
    }
    println()

    for(i in list3)
    {
        print(" " + i)
    }
    println()
}