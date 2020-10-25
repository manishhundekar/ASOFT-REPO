package day2

class PrimaryConst2(name: String, id: Int) {
    val name: String
    var id: Int

    init {
        this.name = name
        this.id = id
        println("Name = $name")
        println("Id = $id")
    }
}


fun main(args: Array<String>) {
    val obj1 = PrimaryConst2("Suresh", 101)
}