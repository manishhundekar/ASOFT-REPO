package basetwo;
import java.util.Random; 
abstract class Medicine
{
	private double price;
	private String expiry;
	
	public String getDetails()
	{
		return price + expiry;
	}
	
	
	public Medicine(double price, String expiry) {
		this.price = price;
		this.expiry = expiry;
	}


	abstract public void displayLabel();
}

class Tablet extends Medicine
{
	public Tablet(double price,String expiry)
	{
		super(price,expiry);
	}
	
	public void displayLabel()
	{
		System.out.println("Tablet Details : " + getDetails() + "(Store in a Cool dry place)");
	}
}

class Syrup extends Medicine
{
	public Syrup(double price,String expiry)
	{
		super(price,expiry);
	}
	
	public void displayLabel()
	{
		System.out.println("Syrup Details : " + getDetails() + "(As prescribed by the Physician)");
	}
}

class Ointment extends Medicine
{
	public Ointment(double price,String expiry)
	{
		super(price,expiry);
	}
	
	public void displayLabel()
	{
		System.out.println("Ointment Details : " + getDetails() + "(For External Use only)");
	}
}



public class InheritanceAbstraction2 {
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) {
		Random rand = new Random(); 
		Medicine [] medicines = new Medicine[5];
		for (int i=0 ; i<5 ; i++)
		{
			int number = getRandomNumber(1,4) ;
			switch(number)
			{
			case 1 : medicines[i] = new Tablet(145.99,"Jun-2025"); break;
			case 2 : medicines[i] = new Syrup(145.99,"Apr-2025"); break;
			case 3 : medicines[i] = new Ointment(145.99,"Mar-2025"); break;
			}
		}
		
		for(Medicine m : medicines)
		{
			m.displayLabel();
		}

	}

}
