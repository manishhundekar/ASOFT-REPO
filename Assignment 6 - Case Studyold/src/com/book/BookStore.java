package com.book;

import java.util.Scanner;

public class BookStore {
	private static int noofbooks = 0;
	private Book [] books = new Book[20];
	
	public void addBook(Book b)
	{
		books[noofbooks++] = b ;
		System.out.println("Book added Successfully");
	}
 	
	public void searchByTitle(String title)
	{
		for(Book i : books)
		{
			if(i == null) {continue;}
			if(i.getTitle().equals(title))
			{
				System.out.println("Book :" + i.getBookId());
			}
		}
	}
	
	public void searchByAuthor(String author)
	{
		for(Book i : books)
		{
			if(i == null) {continue;}
			if(i.getAuthor().equals(author))
			{
				System.out.println("Book :" + i.getBookId());
			}
		}
	}
	
	
	
	public void displayAll()
	{
		for(Book i : books)
		{
			if(i == null) {continue;}
			System.out.println("Book ID : " + i.getBookId() + "\nBook Title : " + i.getTitle() + "\nBook Author : " + i.getAuthor() + "\nCategory" + i.getCategory() + "\nPrice : " + i.getPrice()  );
		}
	}
	
	public void displayBook(String bookID)
	{
		for(Book i : books)
		{
			if(i == null) {continue;}
			if(i.getBookId().equals(bookID))
			{
				System.out.println("Book ID : " + i.getBookId() + "\nBook Title : " + i.getTitle() + "\nBook Author : " + i.getAuthor() + "\nCategory" + i.getCategory() + "\nPrice : " + i.getPrice()  );
				break;
			}
		}
	}
	
	public void updateBook(String bookID)
	{
		System.out.println("Choose an Field to be updated \n1.Book Title \n2.Book Author \n3.Book Category \n4.Book Price");
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int option = sc.nextInt();
		switch(option)
		{
			case 1 : 
				for(Book i : books)
				{
					if(i == null) {continue;}
					if(i.getBookId().equals(bookID))
					{
						System.out.println("Enter the New Book Title");
						i.setTitle(sc1.nextLine());
						break;
					}
				}
			case 2 : 
				for(Book i : books)
				{
					if(i == null) {continue;}
					if(i.getBookId().equals(bookID))
					{
						System.out.println("Enter the New Book Author");
						i.setAuthor(sc1.nextLine());
						break;
					}
				}
			case 3 : 
				for(Book i : books)
				{
					if(i == null) {continue;}
					if(i.getBookId().equals(bookID))
					{
						System.out.println("Enter the New Book Category");
						i.setCategory(sc1.nextLine());
						break;
					}
				}
			case 4 : 
				for(Book i : books)
				{
					if(i == null) {continue;}
					if(i.getBookId().equals(bookID))
					{
						System.out.println("Enter the New Book Price");
						i.setPrice(sc1.nextFloat());
						break;
					}
				}
			default : System.out.println("Invalid Option"); break;
		}
		sc.close();
		sc1.close();
		
	}
	
}
