package assignments

//Search for the given element in the Array using functions

fun searchElement( arr : Array<Int> , element : Int)
{
    if (element in arr){
        println("Element Found")
    }
    else
    {
        println("Element Not found")
    }
}
fun main()
{
    var numberArr = arrayOf(10,20,30,40,50)
    searchElement(numberArr,50)
    searchElement(numberArr,25)
}