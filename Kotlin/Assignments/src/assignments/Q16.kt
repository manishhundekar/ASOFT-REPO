package assignments

//Create a list as follows:
//	stringList, mixedList, intList to accept some data and
//	write a kotlin fun using generics to display the value of each list.

fun <E>printList(list : List<E>)
{
    for(item in list)
    {
        print("$item \t")
    }
    println()
}

fun main()
{
    var stringList = listOf<String>("Ramesh","Rakul")
    var mixedList = listOf<Any>("Suresh",25,true)
    var IntList = listOf<Int>(10,25,36)

    printList(stringList)
    printList(mixedList)
    printList(IntList)
}