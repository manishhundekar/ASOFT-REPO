import java.util.Scanner;
public class ProfitLoss {

	public static void main(String[] args) {
		// Profit and Loss
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter the number of dozens of eggs purchased:");
		//int dozens = sc.nextInt();
		System.out.println("Enter the price per dozen:");
		double priceperdozen = sc.nextDouble();
		System.out.println("Enter the selling price of each egg:");
		int sellpriceperegg = sc.nextInt();
		double costpriceperegg = priceperdozen/12;
		double gain = sellpriceperegg - costpriceperegg;
		double profitpercent = (gain/costpriceperegg)*100;
		System.out.printf("Harish's Profit percentage is %.2f percent", profitpercent);
		sc.close();
	}

}
