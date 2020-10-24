package com.sanid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanid.pojo.Contact;
import com.sanid.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	
	public String handleAddCtctHyperlink(Model model) {
		return null;}
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contact = contactService.getContactById(contactId);
		model.addAttribute("contact", contact);
		
		return "index";
		} 

	/* save method will perform operation of update
	 * public String updateContact(Contact c,Model model) { return null;}
	 */
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid, RedirectAttributes redir) {
		contactService.deleteContactById(cid);
		redir.addFlashAttribute("delSucc", "Contact Deleted Successfully.");
		
		return "redirect:viewContacts";
		}
}