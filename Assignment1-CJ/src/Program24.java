import java.util.Scanner;
public class Program24 {

	public static void main(String[] args) {
		// Sum of three number using interative user
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the First number: ");
		int one = sc.nextInt();
		System.out.println("Please enter the Second number: ");
		int two = sc.nextInt();
		System.out.println("Please enter the Third number: ");
		int three = sc.nextInt();
		System.out.println("The Sum of three numbers are : " + (one+two+three));
		sc.close();
	}

}
