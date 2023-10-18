package mainDemo;

import ro.emanuel.dao.StudentDAO;
import ro.emanuel.pojo.Student;
import ro.helpers.DBhelper;

public class Main {

	public static void main(String[] args) {
		/*	ArrayList<Rubik> rubikcube =RubikDAO.getAll();
		for(Student r:rubikcube) {
			System.out.println(s.getManufactured() + " "+ s.getBrand());
		}
		
		Rubik r1 = RubikDAO.getBrand("");
		if(s1!=null) {
			System.out.println("Cubul cu  brand="MoFang" are data " +s1.getManufactured());
		}
		else {
			System.out.println("Nu exista cub cu brand="MoFang"");
		}
	
		
		/*boolean actualizat = RubikDAO.update(r1);
		if(actualizat == true) {
			System.out.println("Cubul a fost actualizat");
		}else {
			System.out.println("Cubul nu a fost gasit in db.");
		}*/
	//	String delete = StudentDAO.delete("MoFang");
	//	System.out.println(delete);
		
		Rubik cubelelo = new Rubik("Cubelelo", "70", 6,"22/02/2020");
		RubikDAO.create(cubelelo);
		DBhelper.closeConnection();

	}

}
