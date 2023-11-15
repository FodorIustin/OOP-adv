package com.work;

public class Wood {
	
	private int id;
	private double height;
	private double width;
	private String material;
	private String date;
	public Wood(int id, double height, double width, String material, String date) {
		this.id = id;
		this.height = height;
		this.width = width;
		this.material = material;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
