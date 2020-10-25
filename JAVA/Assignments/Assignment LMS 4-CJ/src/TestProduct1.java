
class Product1{
	String productCode;
	String productName;
	double productPrice;
	
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

public class TestProduct1 {

	public static void main(String[] args) {
		Product1 pr = new Product1();
		pr.setProductCode("P101");
		pr.setProductName("Laptop");
		pr.setProductPrice(45000.00);
		System.out.println("Product Code :" + pr.productCode + "\nProduct Name :" + pr.productName + "\nProduct Price :" + pr.productPrice);
	}

}