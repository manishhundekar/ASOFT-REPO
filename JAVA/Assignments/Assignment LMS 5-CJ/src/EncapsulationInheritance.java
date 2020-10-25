import java.util.Scanner;
class Book
{
	private int bookNO;
	private String title;
	private String author;
	private float price;
	public int getBookNO() {
		return bookNO;
	}
	public void setBookNO(int bookNO) {
		this.bookNO = bookNO;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Book(int bookNO, String title, String author, float price) {
		super();
		this.bookNO = bookNO;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book() {}
	
}

class EngineeringBook extends Book
{
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public EngineeringBook(int bookNo,String title,String author,float price,String category) {
		super(bookNo,title,author,price);
		this.category = category;
	}
	
	
}

public class EncapsulationInheritance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Book book = new Book();
		System.out.println("Enter Book No:");
		book.setBookNO(sc.nextInt());
		System.out.println("Enter Book Title:");
		book.setTitle(sc1.nextLine());
		System.out.println("Enter Book Author:");
		book.setAuthor(sc1.nextLine());
		System.out.println("Enter Book Price:");
		book.setPrice(sc.nextFloat());
		System.out.println("Book no : " + book.getBookNO() + " \nBook Title:" + book.getTitle() + " \nBook Author:" + book.getAuthor() + "\nBook Price:" + book.getPrice());
		sc.close();
		sc1.close();
		//2
		EngineeringBook eb = new EngineeringBook(11,"Computer Organization","Mr. Kapil",255,"Computer Architecture");
		System.out.println("Book no : " + eb.getBookNO() + " \nBook Title:" + eb.getTitle() + " \nBook Author:" + eb.getAuthor() + "\nBook Price:" + eb.getPrice() + "\nBook Category:" + eb.getCategory() );
	}

}
