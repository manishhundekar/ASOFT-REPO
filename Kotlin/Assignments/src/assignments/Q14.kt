package assignments

//Declare a class Student with rollno, studentName, City as properties of the class.
// Store the values in immutable Map for 10 instances and write a code to iterate the Map
// Object to display only the students from “Bangalore”

class Student(var rollNo : Int , var studentName : String , var city : String){

    fun displayDetails()
    {
        print("Roll No : $rollNo \tName : $studentName \tCity : $city")
    }
}

fun main()
{

    var stu1 = Student(100,"John","Bangalore")
    var stu2 = Student(101,"Peter","Chennai")
    var stu3 = Student(102,"Mark","Mumbai")
    var stu4 = Student(103,"Ravi","Bangalore")
    var stu5 = Student(104,"Meera","Mumbai")
    var stu6 = Student(105,"Usha","Chennai")
    var stu7 = Student(106,"Rekha","Chennai")
    var stu8 = Student(107,"Sunil","Bangalore")
    var stu9 = Student(108,"Tara","Chennai")
    var stu10 = Student(109,"Sun","Mumbai")
    var stu11 = Student(110,"Ramu","Bangalore")
    var studentMap = mapOf<Int,Student>(1 to stu1 , 2 to stu2 ,3 to stu3 ,4 to stu4 ,5 to stu5 ,6 to stu6 ,7 to stu7 ,8 to stu8 ,9 to stu9 ,10 to stu10 ,11 to stu11)


    //Iterate
    for(item in studentMap.values)
    {
        if(item.city.equals("Bangalore"))
        {
            item.displayDetails();
        }
    }
}