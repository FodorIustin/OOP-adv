package workPOJO;

public class Rubik {
	
	private String brand;
	private double weight;
	private int sides;
	private String manfufactured;
	
	public Rubik() {
		
	}

	public Rubik(String brand, double weight, int sides, String manfufactured) {
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
		this.manfufactured = manfufactured;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public String getManfufactured() {
		return manfufactured;
	}

	public void setManfufactured(String manfufactured) {
		this.manfufactured = manfufactured;
	}
	
}
