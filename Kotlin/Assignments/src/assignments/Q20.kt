package assignments

//Write a kotlin program to add two dates.

import java.util.Calendar

fun main()
{
    var cal1 = Calendar.getInstance()
    cal1.set(2020,1,26)
    println(cal1.get(Calendar.MONTH))
    //---------------------------------
    var cal2 = Calendar.getInstance()
    cal2.set(2020,6,26)
    println(cal2.get(Calendar.MONTH))
    //---------------------------------
  // var cal3 = Calendar.getInstance()
    //val cal3 = cal1.clone() as Calendar
   // println(cal3.get(Calendar.MONTH))
    //cal3.add(cal1.get(Calendar.MONTH) , +2)
    //println(cal3.get(Calendar.MONTH))

    println(cal1.get(Calendar.MONTH) + cal2.get(Calendar.MONTH))
}
