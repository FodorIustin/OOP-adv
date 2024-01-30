package ro.library.pojo;

public class Employee {
	
	private String firstName;
	private String lastName;
	private int age;
	private int employeeID;
	
	
	public Employee(String firstName, String lastName, int age, int employeeID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.employeeID = employeeID;
	}

	public Employee() {
		
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
}
