import java.util.Scanner;
public class PartiID {

	public static void main(String[] args) {
		// Search Participant IDs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of participants:");
		int n = sc.nextInt();
		int [] ids = new int[n];
		System.out.println("Enter the IDs:");
		for(int i=0 ; i<n ; i++)
		{
			ids[i]=sc.nextInt();
		}
		int search,flag;
		while(true)
		{
			System.out.println("Enter ID to search:");
			search = sc.nextInt();
			if(search == 0) {break;}
			flag = 0;
			for(int item : ids)
			{
				if(item == search)
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("Participant with ID " + search + " exists");
			}
			else
			{
				System.out.println("Participant with ID " + search + " does not exists");
			}
		}
		System.out.println("Terminated");
		sc.close();
	}

}
