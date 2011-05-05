package net.caimito.courseware.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/updatePet")
public class UpdatePetController {

	@Autowired
	private PetStore petStore ;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView editPet(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView() ;
		mav.addObject("pet", petStore.findPet(id)) ;
		mav.setViewName("editPet") ;
		return mav ;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status) {
		if (result.hasErrors())
			return "editPet" ;
		else {
			petStore.updatePet(pet) ;
			status.setComplete() ;
			return "redirect:availablePets" ;
		}
	}

	
}
