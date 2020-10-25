package assignments

fun vowelsCount( str : String) : Int
{
    var vowels = arrayOf('a','e','i','o','u')
    var count = 0;
    for(c in str)
        if(c in vowels)
            count ++
    return count
}


fun main()
{
    var str : String = "My Name is Rahul Dravid and i am from Bangalore"
    println("Count : ${vowelsCount(str)}")
}