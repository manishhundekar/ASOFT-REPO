import java.util.Scanner;
public class Marks {

	public static void main(String[] args) {
		// Marks
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students:");
		int noofstud = sc.nextInt();
		int [] marks = new int[noofstud];
		int min=999,max=0,sum=0;
		System.out.println("Enter marks scored:");
		for(int i=0; i<noofstud ; i++)
		{
			marks[i] = sc.nextInt();
			if(marks[i] < min) {min = marks[i];}
			if(marks[i] > max) {max = marks[i];}
			sum += marks[i];
		}
		System.out.println("Minimum marks: " + min);
		System.out.println("Maximum marks: " + max);
		System.out.println("Average marks: " + (sum/noofstud));
		sc.close();
	}

}
