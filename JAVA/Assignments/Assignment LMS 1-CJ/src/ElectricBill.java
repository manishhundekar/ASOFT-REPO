import java.util.Scanner;
public class ElectricBill {

	public static void main(String[] args) {
		// Electric Bill
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the previous reading");
		int prev = sc.nextInt();
		System.out.println("Enter the current reading");
		int curr = sc.nextInt();
		int consumed = curr - prev ;
		float billamount = 0;
		for(int i = 1; i<=consumed; i++)
		{
			if(i <= 30)
			{
				billamount += 2.30 ;
			}
			else if(i>30 && i <= 100)
			{
				billamount += 3.50 ;
			}
			else
			{
				billamount += 4.60 ;
			}
		}
		System.out.printf("Bill Amount is %.2f",billamount);
		sc.close();
	}

}
