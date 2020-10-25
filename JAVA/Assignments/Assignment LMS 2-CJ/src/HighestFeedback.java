import java.util.Scanner;
public class HighestFeedback {

	static int [] feedback;
	
	static void highestFeedBack(int [] metlife,int [] hardfort,int size)
	{
		feedback = new int[size*2];
		int index = 0;
		int flag=0;
		for (int i=0;i<size;i+=2)
		{
			flag=0;
			for (int j=0;j<size;j+=2)
			{
				if(metlife[i]==hardfort[j])
				{
					flag=1;
					if(metlife[i+1]>=hardfort[j+1])
					{
						feedback[index++]=metlife[i];
						feedback[index++]=metlife[i+1];
					}
					else
					{
						feedback[index++]=hardfort[j];
						feedback[index++]=hardfort[j+1];
					}
					break;
				}
			}
			if(flag==0)
			{
				feedback[index++]=metlife[i];
				feedback[index++]=metlife[i+1];
			}
		}
		
		//
		for (int j=0;j<size;j+=2)
		{
			flag=0;
			for (int i=0;i<size;i+=2)
			{
				if(metlife[i]==hardfort[j])
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				feedback[index++]=hardfort[j];
				feedback[index++]=hardfort[j+1];
			}
		}
	}
	
	public static void main(String[] args) {
		// Highest Feedback
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<1) {System.out.println("Invalid Array Size"); System.exit(0);}
		int [] data1 = new int[n];
		int [] data2 = new int[n];
		for(int i=0; i<n ; i++)
		{
			data1[i] = sc.nextInt();
			if(data1[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		for(int i=0; i<n ; i++)
		{
			data2[i] = sc.nextInt();
			if(data2[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		highestFeedBack(data1,data2,n);
		for(int i : feedback)
		{
			System.out.println(i);
		}
		sc.close();
	}

}
