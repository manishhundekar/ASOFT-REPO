package assignments

//Join two list

fun main()
{
    var list1 = listOf<Int>(1,2,3)
    var list2 = listOf<Int>(4,5,6)
    var list3 = ArrayList<Int>();
    list3.addAll(list1)
    list3.addAll(list2)
    printList(list3)
}