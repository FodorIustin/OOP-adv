package com.example;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WatchController {
	
	WatchDao watchDao = new WatchDao();

	@GetMapping("/watches/{id}")
	public ModelAndView wacthPageById (@PathVariable int id) throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView("singleWatch"); 
		//get watch from db
		Watch watch = watchDao.getById(id);
		System.out.println(watch.getBrand());
		//set it in the page
		mav.addObject("wa", watch);
		return mav;
	}
	@GetMapping("/watches")
	public ModelAndView getAllWatches() {
		ModelAndView mav = new ModelAndView("watches");
		return mav;
	}
	
	
	
	
}
