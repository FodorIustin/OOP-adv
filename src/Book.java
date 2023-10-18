package workPOJO;

public class Book {
	
	private int id;
	private String title;
	private int price;
	private String author;
	
	public Book() {
		
	}
	public Book(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public Book(int id, String title, int price, String author) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
}
