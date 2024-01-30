package ro.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.library.dao.BookDao;
import ro.library.dao.EmployeeDao;
import ro.library.dao.SectionDao;
import ro.library.pojo.Book;
import ro.library.pojo.Employee;
import ro.library.pojo.Section;



@Controller
public class BookController {

	@GetMapping("/books/all")
	public ModelAndView listAll() throws SQLException {
	    ArrayList<Book> books = BookDao.getAllBooks();
	    ArrayList<Employee> employees = EmployeeDao.getAllEmployees();
	    ArrayList<Section> sections = SectionDao.getAllSections();

	    ModelAndView mv = new ModelAndView("allbooks");
	    mv.addObject("books", books);
	    mv.addObject("employees", employees);
	    mv.addObject("sections", sections);
	    
	    return mv;
	}

	@GetMapping("/books/{id}")
	public ModelAndView bookPageById(@PathVariable int id) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("singlebook");
		// get the watch from db
		Book book = BookDao.getById(id);

		mav.addObject("book", book);

		return mav;
	}
	
	@GetMapping("/books/edit/{id}")
	public ModelAndView bookEditGet(Model model, @PathVariable int id) throws SQLException, IOException {
		
		Book book = BookDao.getById(id);
		model.addAttribute("book", book);

		return new ModelAndView("editbook","model",model);
	}
	
	@PostMapping("/books/edit")
	public ModelAndView bookEditSave(@ModelAttribute("book") Book b,
			ModelMap model, BindingResult result) {
		
		try {
			BookDao.update(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/books/add")
	public ModelAndView bookAddGet(Model model) throws SQLException, IOException {
		
		Book book = new Book();
		model.addAttribute("book", book);

		return new ModelAndView("addbook","model",model);
	}
	
	@PostMapping("/books/add")
	public ModelAndView bookAddSave(@ModelAttribute("book") Book b,
			ModelMap model, BindingResult result) {
		
		try {
			BookDao.create(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/books/delete/{id}")
	public ModelAndView bookDelete(@PathVariable int id) throws SQLException, IOException {
		
		BookDao.delete(id);

		return new ModelAndView("redirect:/books/all");
	}
}
