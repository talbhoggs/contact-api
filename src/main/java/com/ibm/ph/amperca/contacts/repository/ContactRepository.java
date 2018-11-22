package com.ibm.ph.amperca.contacts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ph.amperca.contacts.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	Optional<Contact> findById(Long id);
}
