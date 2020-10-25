import java.util.Scanner;
public class Assesment1Q2 {

	public static void main(String[] args) {
		int temp=0,student=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("The No of AC Temperatures");
		int n = sc.nextInt();
		System.out.println("Enter the temperatures");
		int [] input = new int[n];
		for(int i=0 ; i<n ; i++)
		{
			input[i] = Integer.parseInt(sc.next());
		}
		for (int i : input)
		{
			temp += i ;
		}
		temp = temp/n;
		System.out.println("Enter Threshold Temperature");
		int t = sc.nextInt();
		System.out.println("The No of students that can be accomodated");
		int noofst = sc.nextInt();
		while(t>=temp)
		{
			student++;
			if(student%noofst==0)
			{
				temp += 2;
			}
		}
		System.out.println(temp);
		System.out.println("No of students :" + student);
		sc.close();
	}

}