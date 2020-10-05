
class Product{
	String productCode;
	String productName;
	double productPrice;
	
}

public class TestProduct {

	public static void main(String[] args) {
		Product pr = new Product();
		System.out.println(pr.productCode + "\n" + pr.productName + "\n" + pr.productPrice);
		Product pr1 = new Product();
		pr1.productCode = "P101";
		pr1.productName = "Laptop";
		pr1.productPrice = 45000.00;
		System.out.println("Product Code :" + pr1.productCode + "\nProduct Name :" + pr1.productName + "\nProduct Price :" + pr1.productPrice);
	}

}