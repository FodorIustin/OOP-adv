package com.work;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WoodController {
	
	WoodDao woodDao = new WoodDao();

	@GetMapping("/doors/{id}")
	public ModelAndView woodPageById (@PathVariable int id) throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView("singleWood"); 
		//get watch from db
		Wood wood = woodDao.getById(id);
		//set it in the page
		mav.addObject("w", wood);
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
	@GetMapping("doors/create")
	public ModelAndView createDoor() {
		return new ModelAndView("addDoor");
	}
	@PostMapping("doors/create")
	public ModelAndView createNewDoor(@RequestParam double height, @RequestParam double width,@RequestParam String material, @RequestParam Date installationDate)throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("doors");
		Wood wood = new Wood(height,width,material,installationDate);
		woodDao.insertDoor(wood);
		
		ArrayList<Wood> woods = woodDao.getAllWoods();
		mav.addObject("woods", woods);
		return mav;
	}
	
	
}
