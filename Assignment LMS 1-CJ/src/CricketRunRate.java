import java.util.Scanner;
public class CricketRunRate {

	public static void main(String[] args) {
		// CRICKET RUN RATE
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of overs bowled so far");
	int noofovers = sc.nextInt();
	System.out.println("Enter the current run rate");
	double crr = sc.nextDouble();
	System.out.println("Enter the target score");
	int target = sc.nextInt();
	double rrr = (target - (crr*noofovers))/(50-noofovers);
	System.out.printf("Required run rate is %.2f",rrr);
	sc.close();
	}

}
