package com.work;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WoodController {
	
	WoodDao woodDao = new WoodDao();

	@GetMapping("/doors/{id}")
	public ModelAndView wacthPageById (@PathVariable int id) throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView("singleWood"); 
		//get watch from db
		Wood wood = woodDao.getById(id);
		System.out.println(wood.getMaterial());
		//set it in the page
		mav.addObject("wo", wood);
		return mav;
	}
	@GetMapping("/doors")
	public ModelAndView getAllWoods() throws SQLException {
		ModelAndView mav = new ModelAndView("woods");
		ArrayList<Wood> woods = woodDao.getAllWoods();
		System.out.println("size is "+ woods.size()) ;
		mav.addObject("woods", woods);
		return mav;
	}
	
	
	
	
}
