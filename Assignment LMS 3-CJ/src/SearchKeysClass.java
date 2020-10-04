import java.util.Scanner;
public class SearchKeysClass {

	static int [] found;
	static void searchKeys(int [] input,int size,int element)
	  {
		int [] temp = new int[20];
		int index=0;
		for(int i=1;i<size;i+=2)
		{
			if(element == input[i])
			{
				temp[index++]=input[i-1];
			}
		}
		found = new int[index];
		for(int i=0 ; i<index ; i++)
		{
			found[i]=temp[i];
		}
	  }
	
	public static void main(String[] args) {
		// SearchKeysClass
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n = sc.nextInt();
		if(n<1) {System.out.println("Invalid Array Size"); System.exit(0);}
		int [] data1 = new int[n];
		for(int i=0; i<n ; i++)
		{
			data1[i] = sc.nextInt();
			if(data1[i]<1) {System.out.println("Invalid Input"); System.exit(0);}
		}
		int element = sc.nextInt();
		searchKeys(data1,n,element);
		for(int i : found)
		{
			System.out.println(i);
		}
		sc.close();
	}

}