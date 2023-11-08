package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LaptopAfis {
		@RequestMapping("/brand/{brandName}")
		public ModelAndView phonePage(@PathVariable String brandName) {
				ModelAndView mav = new ModelAndView();
				
				mav.addObject("pb", brandName);			
				int length = brandName.length();
				mav.addObject("lung", length); 
				
				String paritate;
				if(length %2 == 0)
					paritate ="par";
				else 
					paritate = "impar";
				mav.addObject("par", paritate); 
				mav.setViewName("afislaptop"); 
				return mav;
		}
		
		//POST
		@RequestMapping(value = "/phonePost", method = RequestMethod.POST)
		public ModelAndView bababa() {
			return null;
		}
}
