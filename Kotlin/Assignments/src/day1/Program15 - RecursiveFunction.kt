package Day1

fun factorial(number:Int):Int
{
    if(number==1)
    {
        return 1
    }
    return number * factorial(number-1)
}

fun main(args : Array<String>)
{
    print(factorial(5))
}