package net.caimito.courseware.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addPet")
public class AddPetController {

	@Autowired
	private PetStore petStore ;
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("pet", new Pet()) ;
		return "addPet" ;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status) {
		if (result.hasErrors())
			return "addPet" ;
		else {
			petStore.addPet(pet) ;
			status.setComplete() ;
			return "redirect:availablePets" ;
		}
	}
}
