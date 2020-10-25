package assignments

//Create an extension function to find the Simple Interest of the given principle amount.
//Add this extension function to built in interface MutableMap.

fun <K,V>MutableMap<K,V>.simpleinterest(p:Double ,t:Double ,r:Double ) : Double
{
 return p*t*r/100;
}
fun main()
{
    var obj = mutableMapOf<Int,String>();
    println("Interest : " + obj.simpleinterest(10000.0, 4.0,5.0))
}