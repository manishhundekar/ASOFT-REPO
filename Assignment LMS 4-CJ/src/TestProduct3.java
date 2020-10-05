
class Product3{
	private static int prodCounter = 100;
	String productCode;
	String productName;
	double productPrice;
	char categoryCode;
	
	//Constructor
	
	Product3(String name,double price,char catecode)
	{
		this.productCode = this.generateProductCode();
		this.productName = name;
		this.productPrice = price;
		this.categoryCode = catecode;
	}
	
	Product3(String name,double price)
	{
		this.productCode = this.generateProductCode();
		this.productName = name;
		this.productPrice = price;
		this.categoryCode = 'E';
	}
	// Methods
	
	String getProductDetails()
	{
		return ("Product Code :" + this.productCode + "\nProduct Name :" + this.productName + "\nProduct Price :" + this.productPrice + "\nCategory :" + this.categoryCode);
	}
	
	private String generateProductCode()
	{
		return (this.categoryCode + Integer.toString(++prodCounter));
	}
	//Setters
	
	void setProductCode(String str)
	{
		this.productCode = str;
	}
	void setProductName(String str)
	{
		this.productName= str;
	}
	void setProductPrice(double a)
	{
		this.productPrice = a;
	}
	void setCategoryCode(char a)
	{
		this.categoryCode = a;
	}
	
	//Getters
	
	String getProductCode()
	{
		return this.productCode ;
	}
	String getProductName()
	{
		return this.productName ;
	}
	double getProductPrice()
	{
		return this.productPrice ;
	}
	char getCategoryCode()
	{
		return this.categoryCode ;
	}
}

public class TestProduct3 {

	public static void main(String[] args) {
		Product3 pr = new Product3("Laptop",45000.00,'E');
		System.out.println("Output :" + pr.getProductDetails());
		Product3 pr1 = new Product3("Laptop",45000.00);
		System.out.println("Output :" + pr1.getProductDetails());
	}

}