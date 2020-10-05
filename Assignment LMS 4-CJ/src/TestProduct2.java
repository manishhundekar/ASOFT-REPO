
class Product2{
	String productCode;
	String productName;
	double productPrice;
	
	//Constructor
	
	Product2(String code,String name,double price)
	{
		this.productCode = code;
		this.productName = name;
		this.productPrice = price;
	}
	
	// Methods
	
	void displayProductDetails()
	{
		System.out.println("Product Code :" + productCode + "\nProduct Name :" + productName + "\nProduct Price :" + productPrice);
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
}

public class TestProduct2 {

	public static void main(String[] args) {
		Product2 pr = new Product2("P101","Laptop",45000.00);
		pr.displayProductDetails();
	}

}