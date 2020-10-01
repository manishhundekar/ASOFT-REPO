
public class Program17 {

	public static void main(String[] args) {
		//A
		System.out.println("\n\n Series: 1,4,7,10,13");
		int a =1;
		for(int i=1 ; i<10 ; i++)
		{
			if(i==1)
				a = 1 ;
			else
				a = a + 3;
			System.out.println(a);
		}
		
		
		//B
		System.out.println("\n\n Series: -20, -15, -10, -5, 0, 5……");
		for (int j=-20 ; j<=25 ; j=j+5)
		{
			System.out.println(j);
		}
		
		//C
		System.out.println("\n\n Series: 1,-2,3,-4,5,-6 ..");
		for (int k=1 ; k<25 ; k++)
		{
			if(k%2==0)
			{
			System.out.println("-" + k);
			}
			else
			{
			 System.out.println(k);
			}
		}
		
	}

}
