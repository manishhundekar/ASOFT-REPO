package com.test;

import com.shape.*;
public class TestClass {

	public static void main(String[] args) {
		Square sq = new Square(25);
		sq.calcArea();
		sq.calcPeri();
		Rectangle rect = new Rectangle(15,12);
		rect.calcArea();
		rect.calcPeri();
	}
}
