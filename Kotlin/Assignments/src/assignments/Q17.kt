package assignments

//Write a kotlin program to convert Map ( HashMap ) to List

fun main() {

    val map = HashMap<String, String>()
    map.put("Bidar", "Ramesh")
    map.put("Hyderbad", "Sushant")
    map.put("Bangalore", "Kiran")
    val keyList = ArrayList(map.keys)
    val valueList = ArrayList(map.values)
    println("Key List: $keyList")
    println("Value List: $valueList")

}