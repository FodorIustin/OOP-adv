//package com.example;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class PhoneController {
//	//value = "/phone", method = 
//	//GET
//	@RequestMapping("/phone/{brandName}")
//	public ModelAndView phonePage(@PathVariable String brandName) {
//			ModelAndView mav = new ModelAndView();
//			
//			mav.addObject("pb", brandName); // req.Atributte
//			mav.setViewName("topPage"); //getrequestDispacther
//			
//			return mav;
//	}
//	
//	//POST
//	@RequestMapping(value = "/phonePost", method = RequestMethod.POST)
//	public ModelAndView bababa() {
//		return null;
//	}
//	
//}
