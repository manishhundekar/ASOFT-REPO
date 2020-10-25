import java.util.Scanner;

public class ArithmeticOperClass {

	static int performArithmeticOperation(int oper1,int oper2,int operation)
	{
		if(oper1 < 0 || oper2 < 0 || oper1>32767 || oper2>32767 )
		{
			return -1;
		}
		switch(operation)
		{
		case 1 : return oper1 + oper2 ;
		case 2 : return oper1 - oper2 ;
		case 3 : return oper1 * oper2 ;
		case 4 : return oper1 / oper2 ;
		default : return 1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int oper = sc.nextInt();
		int res =performArithmeticOperation(n1,n2,oper);
		if(res == -1)
		{
			System.out.println("Invalid Input");
		}
		else
		{
			System.out.println("Output: " +res);
		}
		sc.close();

	}

}
