package day1

fun main(args : Array<String>)
{
    //Relational Operators

    var a=10
    var b=20
    var max = if(a>b){
        print("A is Greater than B")
        a
    }
    else
    {
        print("B is Greater than A")
        b
    }
    print(max)
}