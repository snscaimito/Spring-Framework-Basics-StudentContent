package net.caimito.courseware.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AvailablePetsController {

	@Autowired
	private PetStore petStore ;
	
	@RequestMapping("/availablePets")
	public ModelAndView availablePets() {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("availablePets") ;
		mav.addObject("pets", petStore.getAvailablePets()) ;
		return mav;
	}

	@RequestMapping("/availableBreeds")
	public ModelAndView availableBreeds() {
		ModelAndView mav = new ModelAndView() ;
		mav.setViewName("availableBreeds") ;
		mav.addObject("breeds", petStore.getAvailablePetBreeds()) ;
		return mav;
	}

}
