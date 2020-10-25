import java.util.Scanner;
public class Assesment1Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter start Value (A)");
		int a = sc.nextInt();
		System.out.println("Enter End Value (I)");
		int i = sc.nextInt();
		for(int m = a ; m<=i ; m++)
		{
			System.out.print(m);
		}
		sc.close();
	}

}
