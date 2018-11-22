package com.ibm.ph.amperca.contacts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ph.amperca.contacts.model.Contact;
import com.ibm.ph.amperca.contacts.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public com.ibm.ph.amperca.contacts.domain.Contact getContact(String id) {
		
		Long idL = Long.valueOf(id);
		Contact cModel = contactRepository.findById(idL).get();
		if(cModel == null ) throw new RuntimeException("Contact not Found!");
		
		return new com.ibm.ph.amperca.contacts.domain.Contact(cModel);
	}
	
	public void save(com.ibm.ph.amperca.contacts.domain.Contact contact) {
		
		Contact cModel = new Contact();
		cModel.setId(null);
		cModel.setEmail(contact.getEmail());
		cModel.setFirstName(contact.getFirstName());
		cModel.setLastName(contact.getLastName());
		cModel.setPhone(contact.getPhone());
		
		contactRepository.save(cModel);
	}

	public void update(com.ibm.ph.amperca.contacts.domain.Contact contact, String id) {
		
		Long idL = Long.valueOf(id);
		Contact cModel = contactRepository.findById(idL).get();
		if(cModel == null ) throw new RuntimeException("Contact not Found!");
		
		cModel.setEmail(contact.getEmail());
		cModel.setFirstName(contact.getFirstName());
		cModel.setLastName(contact.getLastName());
		cModel.setPhone(contact.getPhone());
		
		contactRepository.save(cModel);
		
	}
	
	public void delete(String id) {
		Long idL = Long.valueOf(id);
		
		Contact cModel = contactRepository.findById(idL).get();
		if(cModel == null ) throw new RuntimeException("ID " + id + " cannot be found");
		
		contactRepository.deleteById(idL);
	}
	
	public Iterable<Contact> getContacts(){
		
		return contactRepository.findAll();
		
	}
}
