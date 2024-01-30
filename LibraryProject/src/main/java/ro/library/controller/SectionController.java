package ro.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;  // Import the Controller annotation
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.library.dao.SectionDao;
import ro.library.pojo.Section;

@Controller  // Add the Controller annotation
public class SectionController {

    @GetMapping("/sections/{id}")
    public ModelAndView sectionPageById(@PathVariable int id) throws SQLException, IOException {
        ModelAndView mav = new ModelAndView("singlesection");
        // get the watch from db
        Section section = SectionDao.getById(id);
        mav.addObject("section", section);
        return mav;
    }
    @GetMapping("/sections/edit/{id}")
	public ModelAndView sectionEditGet(Model model, @PathVariable int id) throws SQLException, IOException {
		
		Section section = SectionDao.getById(id);
		model.addAttribute("section", section);

		return new ModelAndView("editsection","model",model);
	}
	
	@PostMapping("/sections/edit")
	public ModelAndView sectionEditSave(@ModelAttribute("section") Section s,
			ModelMap model, BindingResult result) {
		
		try {
			SectionDao.update(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/sections/add")
	public ModelAndView sectionAddGet(Model model) throws SQLException, IOException {
		
		Section section = new Section();
		model.addAttribute("section", section);

		return new ModelAndView("addsection","model",model);
	}
	
	@PostMapping("/sections/add")
	public ModelAndView sectionAddSave(@ModelAttribute("section") Section s,
			ModelMap model, BindingResult result) {
		
		try {
			SectionDao.create(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/books/all");
	}
	
	@GetMapping("/sections/delete/{id}")
	public ModelAndView sectionDelete(@PathVariable int id) throws SQLException, IOException {
		
		SectionDao.delete(id);

		return new ModelAndView("redirect:/books/all");
	}
}
