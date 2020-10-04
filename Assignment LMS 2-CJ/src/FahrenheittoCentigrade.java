import java.util.Scanner;
public class FahrenheittoCentigrade {

	static float convertToCentigrade(int f)
	{
		return ((f-32)/9)*5;
	}
	public static void main(String[] args) {
		// Fahrenheit to Centigrade
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int fahrenheit = sc.nextInt();
		if(fahrenheit<1) {System.out.println("Invalid Input"); System.exit(0);}
		System.out.printf("Centigrade= %.2f",convertToCentigrade(fahrenheit));
		sc.close();
	}

}
