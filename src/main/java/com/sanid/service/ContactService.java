package com.sanid.service;

import java.util.List;

import com.sanid.pojo.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	
	public boolean updateContact(Contact contact);
	
	public boolean deleteContactById(Integer cid);
}  