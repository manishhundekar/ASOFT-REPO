package assignments

/*
fun simpleInterest(p: Float, t: Float, r : Float ,mylambda : (Float) -> Unit ){
    mylambda((p*t*r)/100)
}

fun main(args: Array<String>){
    val myLambda= {s: Float -> println(s) }
    simpleInterest(10000f,3f,5f,myLambda)
}*/

fun main(args: Array<String>){
    val myLambda= {p: Float , t:Float , r:Float -> println("Simple Interest :" + (p*t*r)/100) }
    myLambda(1000f,3f,5f)
}