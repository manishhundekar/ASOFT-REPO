package com.book;

public class Book {

	private String bookId;
	private String title;
	private String author;
	private String category;
	private float price;
	
	public Book(String bookId, String title, String author, String category, float price) throws InvalidInputException{
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others"))
		{
			if(price >= 0)
			{
				if(bookId.startsWith("B") && bookId.length() == 4)
				{
					this.bookId = bookId;
					this.title = title;
					this.author = author;
					this.category = category;
					this.price = price;
				}
				else
				{
					System.out.println("Invalid Book ID. \nIt should start with B and must be of 4 characters");
					throw new InvalidInputException();
				}
			}
			else
			{
				System.out.println("Invalid Price");
				throw new InvalidInputException();
			}
		}
		else
		{
			System.out.println("Invalid Book Category");
			throw new InvalidInputException();
		}
		
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
