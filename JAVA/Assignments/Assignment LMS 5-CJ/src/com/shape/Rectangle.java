package com.shape;

public class Rectangle implements Polygon{
	private float length;
	private float breadth;
	public Rectangle(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	public Rectangle() {}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getBreadth() {
		return breadth;
	}
	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}
	@Override
	public void calcArea()
	{
		System.out.println("Area of Rectangle : " + getBreadth() * getLength());
	}
	@Override
	public void calcPeri()
	{
		System.out.println("Perimeter of Rectangle : " + 2 * (getBreadth() + getLength() ));
	}
	
}
