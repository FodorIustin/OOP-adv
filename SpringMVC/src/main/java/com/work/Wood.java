package com.work;

import java.sql.Date;

public class Wood {
	
	private int id;
	private double height;
	private double width;
	private String material;
	public Date installationDate;
	public Wood(double height, double width, String material, Date date) {
		this.height = height;
		this.width = width;
		this.material = material;
		this.installationDate = date;
	}
	public Wood(int id, double height, double width, String material, Date date) {
		this.id = id;
		this.height = height;
		this.width = width;
		this.material = material;
		this.installationDate = date;
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
	public Date getInstallationdate() {
		return installationDate;
	}
	public void setInstallationdate(Date installationdate) {
		this.installationDate = installationdate;
	}
	
	
	
}
