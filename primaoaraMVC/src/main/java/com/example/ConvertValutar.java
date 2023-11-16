//package com.example;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class ConvertValutar {
//	
//	@RequestMapping("/convert/{valutaEuro}/{valutaLei}")
//	public ModelAndView phonePage(@PathVariable String valutaEuro, String valutaLei) {
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("euro", valutaEuro);
//			mav.addObject("lei", valutaLei);
//			
//			int a = Integer.parseInt(valutaLei);
//			int b= Integer.parseInt(valutaEuro);
//			mav.addObject("nrEuro", a/b);
//			
//			mav.setViewName("afisConvert"); 
//			
//			
//			return mav;
//	}
//	
//	//POST
//	@RequestMapping(value = "/phonePost", method = RequestMethod.POST)
//	public ModelAndView bababa() {
//		return null;
//	}
//}
