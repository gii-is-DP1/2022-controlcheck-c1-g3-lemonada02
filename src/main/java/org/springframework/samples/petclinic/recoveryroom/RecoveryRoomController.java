package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryRoom")
public class RecoveryRoomController {
    
	private final String VIEW_RECOVERYROOMS_CREATE_FORM= "owners/createOrUpdateRecoveryRoomForm";
	private final String WELCOME= "welcome";
	private RecoveryRoomService service;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService service) {
		
		this.service= service;
	}
	
	@GetMapping("/create")
	public String initProduct(ModelMap map) {
		
		map.addAttribute("recoveryRoom", new RecoveryRoom());
		map.addAttribute("types", service.getAllRecoveryRoomTypes());
		return VIEW_RECOVERYROOMS_CREATE_FORM;
	}

	
	@PostMapping(path= "/create")
	public String createRecoveryRoom(@Valid RecoveryRoom rr, BindingResult br, ModelMap mp) throws DuplicatedRoomNameException {
		
		if(br.hasErrors()){
			
			mp.addAttribute("recoveryRoom", rr);
			mp.addAttribute("types", service.getAllRecoveryRoomTypes());
			return VIEW_RECOVERYROOMS_CREATE_FORM;
		} else{
			service.save(rr);
			mp.addAttribute("message", "Recovery Room succesfully save");
		}
		return WELCOME;
	}
}
