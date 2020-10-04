import java.util.Scanner;
public class PTDrill {

	public static void main(String[] args) {
		// PTDrill
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the number of students:");
		int noofstud = sc.nextInt();
		int noofrc = (int)Math.sqrt(noofstud);
		String [][] names = new String[noofrc][noofrc];
		System.out.println("Enter Names:");
		for(int i=0; i<noofrc ; i++)
		{
			for(int j=0; j<noofrc ; j++)
			{
				names[i][j] = sc2.nextLine();
			}
		}
		System.out.println("Middle row: ");
		for(int k = 0 ; k<noofrc ; k++)
		{
			System.out.println(names[1][k] + " ");
		}
		System.out.println("Middle Column: " );
		for(int k = 0 ; k<noofrc ; k++)
		{
			System.out.println(names[k][1] + " ");
		}
		
		sc.close();
		sc2.close();
	}

}
