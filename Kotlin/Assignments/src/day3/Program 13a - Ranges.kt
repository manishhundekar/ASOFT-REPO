package day3
fun main()
{
    //Ranges Reverse
    println("Reverse 1")
    var range1=1..10
    for(x in range1.reversed())
    {
        print(x)
    }
    println()

    //IntRange()
    println("Reverse 2")
    var range2:IntRange=IntRange(1,10)
    for(x in range2.reversed())
    {
        print(x)
    }
    println()

    //IntProgression
    println("Reverse 3")
    var range3=IntProgression.fromClosedRange(10,1,-1)
    for(x in range3.reversed())
    {
        print(x)
    }
    println()

    //IntProgression
    println("Reverse 4")
    var range4=IntProgression.fromClosedRange(10,1,-2)
    for(x in range4.reversed())
    {
        print(x)
    }
}
