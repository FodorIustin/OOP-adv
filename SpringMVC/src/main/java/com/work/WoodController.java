package com.work;

@Controller
public class WoodController {
	
	WoodDao woodDao = new WoodDao();

	@GetMapping("/woods/{id}")
	public ModelAndView wacthPageById (@PathVariable int id) throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView("wood"); 
		//get watch from db
		Wood wood = woodDao.getById(id);
		System.out.println(wood.getMaterial());
		//set it in the page
		mav.addObject("wo", wood);
		return mav;
	}
	
}
