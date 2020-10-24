package com.sanid.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanid.entity.ContactDtlsEntity;
import com.sanid.pojo.Contact;
import com.sanid.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepo;	
	
	/* This	method is used to save contact details */
	@Override
	public boolean saveContact(Contact c) {
		// TODO Auto-generated method stub
		
		ContactDtlsEntity entity = new ContactDtlsEntity();
		
		/*entity.setCname(c.getCname());
		entity.setEmail(c.getEmail());	
		entity.setCnum(c.getCnum());*/
		
		BeanUtils.copyProperties(c , entity);
		
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);
		
		/*if(savedEntity.getCid()!= null) {
			return true;
		}
		else {
			return false;
		}*/
					
		
		return savedEntity.getCid() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		
		//String a=null;
		
		
		List<ContactDtlsEntity> entitiesList = contactDtlsRepo.findAll();
		
		List<Contact> contactsList = new ArrayList<Contact>();
		entitiesList.forEach(entity ->{
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contactsList.add(c);
		});
		
		return contactsList;
	}

	@Override
	public Contact getContactById(Integer cid) {
		// TODO Auto-generated method stub
		Contact con=new Contact();
		Optional<ContactDtlsEntity> optional = contactDtlsRepo.findById(cid);
		if(optional.isPresent()) {
			ContactDtlsEntity entity = optional.get();
			Contact c= new Contact();
			BeanUtils.copyProperties(entity, c);
			con=c;
		}
		return con;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		// TODO Auto-generated method stub
			contactDtlsRepo.deleteById(cid);
		
		return true;
	}

}
