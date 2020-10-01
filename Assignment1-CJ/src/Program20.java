import java.util.*;
public class Program20 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter Fahrenheit : \n");
        double fahrenheit = input.nextDouble();
        double  celsius =(( 5 *(fahrenheit - 32.0)) / 9.0);
        System.out.println("Celsius :" + celsius);
        input.close();
	}

}
