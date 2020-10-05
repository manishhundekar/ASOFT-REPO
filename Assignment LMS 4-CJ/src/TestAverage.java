class Averager
{
	 static double avg(int a,int b)
	 {
		 return (double) a+b/2;
	 }
	 static double avg(int a,int b,int c)
	 {
		 return (double) a+b+c/3;
	 }
	 static double avg(double a,double b)
	 {
		 return  a+b/2;
	 }
}

public class TestAverage {

	public static void main(String[] args) {
		System.out.println("Method 1 :" + Averager.avg(10,20));
		System.out.println("Method 2 :" + Averager.avg(10,20,30));
		System.out.println("Method 3 :" + Averager.avg(10.5,20.5));
	}

}
