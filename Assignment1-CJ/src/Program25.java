
public class Program25 {

	public static void isprime(int number)
	{
		if (number%2==0) 
		{
			System.out.println("Not a Prime Number"); 	
			return ;
		}
	    else
	    {
	    	for(int i=3;i<=Math.sqrt(number);i+=2) 
	    	{ 
		        if(number%i==0) 
		        {
		        	System.out.println("Not a Prime Number"); 
		        }
		        return ;
		        	
		    } 
	    	System.out.println("It is a Prime Number"); 
	    }
	}
	
	public static void main(String[] args) {
		// Prime number by taking the input from the command line
		int number = Integer.parseInt(args[0]);
		isprime(number);	    
}
}