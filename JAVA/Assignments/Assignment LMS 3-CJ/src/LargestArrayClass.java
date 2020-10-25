import java.util.Scanner;

public class LargestArrayClass {

	static int [] output1;
	
	static void LargestArray(int [] arr1,int [] arr2,int size)
	{
		int [] temp = new int[20];
		int index = 0 ;
		for(int i=0; i<size; i++)
		{
			if(arr1[i]>=arr2[i])
			{
				temp[index++] = arr1[i];
			}
			else
			{
				temp[index++] = arr2[i];
			}
		}
		output1 = new int[index];
		for(int k=0;k<index;k++)
		{
			output1[k] = temp[k]; 
		}
	}
	
	public static void main(String[] args) {
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
		LargestArray(data1,data2,n);
		for(int i : output1)
		{
			System.out.println(i);
		}
		sc.close();
	}

}
