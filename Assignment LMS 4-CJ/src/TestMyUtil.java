

class MyUtil
{
	static int throwDice()
	{
		return (int) (Math.random()*6);
	}
	
	static double findAverage(int [] inp)
	{
		int sum=0;
		for(int i : inp)
		{
			sum += i ;
		}
		return sum/inp.length;
	}
}
public class TestMyUtil {

	public static void main(String[] args) {
		System.out.println(MyUtil.throwDice());
		int [] arr1 = {10,20,30,40,50};
		int [] arr2 = {11,12,13,14};
		System.out.println("Array 1: " + MyUtil.findAverage(arr1) + "\nArray 2: " + MyUtil.findAverage(arr2));
		System.out.println("Max :" + Math.max(10.5, 20.6));
		System.out.println("Min :" + Math.min(10.5, 20.6));
		System.out.println("Ceil :" + Math.ceil(10.5));
		System.out.println("Floor :" + Math.floor(10.5));
		System.out.println("Round :" + Math.round(10.6));
	}

}
