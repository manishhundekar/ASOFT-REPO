import java.util.Scanner;
public class NumberPattern {

	public static void main(String[] args) {
		// Number Pattern
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		for(int i=1; i<=n ; i++)
		{
			if(i%3!=0)
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
