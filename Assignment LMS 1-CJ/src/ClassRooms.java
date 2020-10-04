import java.util.Scanner;
public class ClassRooms {

	public static void main(String[] args) {
		// Class Rooms
		int count=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter C1 Capacity:");
		int c1 = sc.nextInt();
		System.out.println("Enter C2 Capacity:");
		int c2 = sc.nextInt();
		System.out.println("Enter C3 Capacity:");
		int c3 = sc.nextInt();
		System.out.println("Enter number of students:");
		int noofstudents = sc.nextInt();
		if (c1 >= noofstudents) {count++;}
		if (c2 >= noofstudents) {count++;}
		if (c3 >= noofstudents) {count++;}
		System.out.println(count + " lab(s) can accommodate " + noofstudents + " students");
		sc.close();
	}

}
