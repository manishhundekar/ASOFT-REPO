package assignments

import java.util.*

//. Create a sealed class Cars add sub classes as Maruti, Hyndai,Honda, accept the type of car as console input
// if the use enters
// Maruti-> Output ->Indian make
//Hyndai-> Output->Korean make
//Honda-> Output-> Japan Make
//Use When expression to display the output.

sealed class Cars{
    class Maruti{
        init{
            println("Indian make")
        }
    }
    class Hyundai{
        init{
            println("Korean make")
        }
    }
    class Honda{
        init{
            println("Japan make")
        }
    }
}

fun main()
{
    var sc = Scanner(System.`in`)
    println("Enter the Car make")
    var inp = sc.nextLine()
    when(inp)
    {
        "Maruti" -> Cars.Maruti()
        "Hyundai" -> Cars.Hyundai()
        "Honda" -> Cars.Honda()
        else -> print("Invalid Input")
    }
}
