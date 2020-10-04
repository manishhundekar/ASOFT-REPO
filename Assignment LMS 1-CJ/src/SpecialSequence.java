import java.util.Scanner;
public class SpecialSequence {

	public static int speseq(int n)
	{
		switch(n)
		{
		case 1 : return 2;
		case 2 : return 1;
		case 3 : return 3;
		default : return speseq(n-1) + speseq(n-2) + speseq(n-3);
		}	
	}
	public static void main(String[] args) {
		// Special Sequence
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int inp = sc.nextInt();
		int i = 1;
		while(speseq(i)<=inp)
		{
			System.out.print(speseq(i) + " ");
			i++;
		}
		sc.close();
	}

}
