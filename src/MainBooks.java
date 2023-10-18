package mainDemo;

import java.sql.SQLException;

import structureDAO.BookDAO;
import workHelpers.DBhelper;
import workPOJO.Book;

//test

public class MainBooks {

	public static void main(String[] args) throws SQLException {
		
		/*	ArrayList<Book> books =BookDAO.getAll();
			for(Book b:books) {
				System.out.println(s.getId() + " "+ s.getTitle());
			}
			
			Books b1 = BooksDAO.getById(1);
			if(b1!=null) {
				System.out.println("Cartea cu id = 1 are titlul " +b1.getTitle());
			}
			else {
				System.out.println("Nu exista Cartea cu id 1");
			}
		//	s1.setId(1);
			//s1.setTitle("1984");
			
			/*boolean actualized = BooksDAO.update(b1);
			if(actualized == true) {
				System.out.println("Cartea a fost actualizat");
			}else {
				System.out.println("Cartea nu a fost gasit in db.");
			}*/
		//	String delete = BooksDAO.delete("1983");
		//	System.out.println(delete);
			
			Book book2 = new Book("1984", 70, "George Orwell");
			BookDAO.create(book2);
			DBhelper.closeConnection();
		}

}
