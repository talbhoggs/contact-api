package com.ibm.ph.amperca.contacts.domain;

public class Contact {

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	public Contact() {

	}

	public Contact(String id, String firstName, String lastName, String email, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;

	}

	public Contact(com.ibm.ph.amperca.contacts.model.Contact contact) {
		this(contact.getId().toString(), contact.getFirstName(), contact.getLastName(), contact.getEmail(),
				contact.getPhone());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
