package com.shape;

public class Square implements Polygon{
	private float side;

	public Square() {}
	public Square(float side) {
		this.side = side;
	}
	
	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}
	@Override
	public void calcArea()
	{
		System.out.println("Area of Square : " + getSide() * getSide());
	}
	@Override
	public void calcPeri()
	{
		System.out.println("Perimeter of Square : " + 4 * getSide());
	}
	
	
}