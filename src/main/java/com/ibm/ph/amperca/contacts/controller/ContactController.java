package com.ibm.ph.amperca.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ph.amperca.contacts.domain.Contact;
import com.ibm.ph.amperca.contacts.messages.Message;
import com.ibm.ph.amperca.contacts.service.ContactService;

@RestController
public class ContactController {
	
	// Testing jenkins build 1

	@Autowired
	ContactService contactService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/contacts")
	public ResponseEntity<Message> createContact(@RequestBody Contact contact) {
		contactService.save(contact);
		return new ResponseEntity<Message>(new Message("200", "INFO", "Contact created successfully!"), HttpStatus.OK);
	}

	@RequestMapping("/api/contacts/{id}")
	public Contact readContact(@PathVariable String id) {

		try {
			contactService.getContact(id);
			return contactService.getContact(id);
		} catch (Exception e) {
			throw e;
		}

	}

	@RequestMapping(method = RequestMethod.PUT, path = "/api/contacts/{id}")
	public ResponseEntity<Message> updateContact(@RequestBody Contact contact, @PathVariable String id) {
		try {
			contactService.update(contact, id);
			return new ResponseEntity<Message>(new Message("200", "INFO", "Update completed!"), HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/api/contacts/{id}")
	public ResponseEntity<Message> deleteContact(@PathVariable String id) {
		try {
			contactService.delete(id);
			return new ResponseEntity<Message>(new Message("200", "INFO", "Contact deleted succussfully!"),
					HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	//1 need to convert this to valid jason format
	@RequestMapping("/api/contacts")
	public Iterable<com.ibm.ph.amperca.contacts.model.Contact> getContacts() {

		return contactService.getContacts();

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	Message messageHandler(RuntimeException e) {
		return new Message("400", "ERROR", e.getMessage());
	}

}
