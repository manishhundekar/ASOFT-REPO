import java.util.Scanner;
public class CircleData {

	public static void main(String[] args) {
		// Circle Data
		double pi = 3.142;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Radius");
		float radius = sc.nextInt();
		System.out.println("Enter Output required");
		String type = sc.next();
		switch(type)
		{
		case "DIA" :System.out.printf("Diameter of a circle is %.2f",2*radius);break;
		case "AR" : System.out.printf("Area of a circle is %.2f",pi*Math.pow(radius, 2));break;
		case "PER" :System.out.printf("Perimeter of a circle is %.2f",2*pi*radius);break;
		case "SEM" :System.out.printf("Area of a  semi-circle is %.2f",pi*radius);break;
		default : System.out.println("Invalid Output");
		}
		sc.close();
	}

}
