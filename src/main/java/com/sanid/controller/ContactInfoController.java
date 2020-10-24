package com.sanid.controller;

import java.util.List;
import java.util.jar.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanid.pojo.Contact;
import com.sanid.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping	(value={"/","createUserAcc"},method= RequestMethod.GET)
	public String loadContactForm (Model model) {//to display form
		
		Contact contactObj = new Contact();
		model.addAttribute("contact" , contactObj);
		
		return "index";
		}
	
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c,RedirectAttributes attributes) {//form submission
		boolean isSaved = contactService.saveContact(c);
		if(isSaved) {
			if(c.getCid()!=null) {
				attributes.addFlashAttribute("sucMsg", "Contact updated successfully!");
			}
			else {
				//model.addAttribute("sucMsg", "Contact saved");
				attributes.addFlashAttribute("sucMsg", "Contact saved!");
			}
		}else {
			attributes.addFlashAttribute("errMsg", "Failed to save contact.");
		}
		return "redirect:createUserAcc";
	}
	
	@RequestMapping(value = "/Success",method = RequestMethod.GET)
	public String Success(Model model) {
		model.addAttribute("contact", new Contact());
		return "index";
		
	}
	
	@GetMapping("/viewContacts")
	public String viewContacts(Model model){// hyperlink
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		
		return "viewContacts";
		}

}