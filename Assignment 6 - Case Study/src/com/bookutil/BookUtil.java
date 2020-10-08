package com.bookutil;

import com.book.*;
import java.util.Scanner;

public class BookUtil {

	public static void main(String[] args) {
		BookStore bookstore = new BookStore();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		boolean status=true;
		while(status)
		{
			System.out.println("Choose an option from the Menu \n1.Add Book \n2.Search Book by Title \n3.Search Book by Author \n4.List all Books \n5.Search Book by ID \n6.Update Book \n7.Exit");
			int option = sc.nextInt();
			switch(option)
			{
			 case 1: 
				 System.out.println("Enter Book ID");
				 String bookId = sc1.nextLine();
				 System.out.println("Enter Book Title");
				 String title = sc1.nextLine();
				 System.out.println("Enter Book Author");
				 String author = sc1.nextLine();
				 System.out.println("Enter Book Category");
				 String category = sc1.nextLine();
				 System.out.println("Enter Book Price");
				 float price = sc1.nextFloat(); 
				try {
					Book book = new Book(bookId,title,author,category,price);
					bookstore.addBook(book);
				}catch(InvalidInputException e)
				{
					e.printStackTrace();
				}
				 break;
			 case 2:
				 System.out.println("Enter Title Name:");
				 String titlesearch = sc1.nextLine();
				 bookstore.searchByTitle(titlesearch);
				 break;
			 case 3:
				 System.out.println("Enter Author Name:");
				 String authorsearch = sc1.nextLine();
				 bookstore.searchByAuthor(authorsearch);
				 break;
			 case 4:
				 bookstore.displayAll();
				 break;
			 case 5:
				 System.out.println("EnterBook ID:");
				 String bookidsearch = sc1.nextLine();
				 bookstore.searchByAuthor(bookidsearch);
				 break;
			 case 6:
				 System.out.println("EnterBook ID:");
				 String bookidupdate = sc1.nextLine();
				 bookstore.updateBook(bookidupdate);
				 break;
			 case 7:
				 status = false; break;
			}
		}
		sc.close();
		sc1.close();
	}
}
