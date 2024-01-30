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

import ro.library.dao.EmployeeDao;
import ro.library.pojo.Employee;

@Controller
public class EmployeeController {
	
//	@GetMapping("/books/all")
//	public ModelAndView list() throws SQLException {
//		ArrayList<Employee> employees = EmployeeDao.getAllEmployees();
//		ModelAndView mv = new ModelAndView("allbooks");
//		mv.addObject("employees", employees);
//		System.out.println("Employees: " + employees);
//		return mv;
//
//	}

	@GetMapping("/employees/{id}")
	public ModelAndView employeePageById(@PathVariable int id) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("singleemployee");
		// get the watch from db
		Employee employee = EmployeeDao.getById(id);

		mav.addObject("employee", employee);

		return mav;
	}
	
	@GetMapping("/employees/edit/{id}")
	public ModelAndView employeeEditGet(Model model, @PathVariable int id) throws SQLException, IOException {
		
		Employee employee = EmployeeDao.getById(id);
		model.addAttribute("employee", employee);

		return new ModelAndView("editemployee","model",model);
	}
	
	@PostMapping("/employee/edit")
	public ModelAndView employeeEditSave(@ModelAttribute("employee") Employee e,
			ModelMap model, BindingResult result) {
		
		try {
			EmployeeDao.update(e);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/employees/add")
	public ModelAndView employeeAddGet(Model model) throws SQLException, IOException {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return new ModelAndView("addemployee","model",model);
	}
	
	@PostMapping("/employee/add")
	public ModelAndView employeeAddSave(@ModelAttribute("employee") Employee e,
			ModelMap model, BindingResult result) {
		
		try {
			EmployeeDao.create(e);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/employees/delete/{id}")
	public ModelAndView employeeDelete(@PathVariable int id) throws SQLException, IOException {
		
		EmployeeDao.delete(id);

		return new ModelAndView("redirect:/books/all");
	}
}
