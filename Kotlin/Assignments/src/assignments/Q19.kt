package assignments

//Write a kotlin program to convert ArrayList to Array

fun main() {
    var arrayListobj = ArrayList<Int>()
    arrayListobj.add(1)
    arrayListobj.add(2)
    arrayListobj.add(3)

    var array = listOf(arrayListobj)
    printList(array)
}