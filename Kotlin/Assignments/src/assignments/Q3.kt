package assignments

//Declare a float range from 45.5 to 100.5
//1. check whether the value 64.5 is present in the range,
//2. if it is available then display the output
//3. Reverse the range and display the output for every alternate number
fun main()
{
    var floatRange = 45.5 .. 100.5 ;
    if (64.5 in floatRange)
        print("64.5 is Present between the given range")
    else
        print("64.5 is not present between the given range")

}