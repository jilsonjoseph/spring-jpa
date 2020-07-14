package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;

	@GetMapping("/contacts")
	public Iterable<Contact> getContacts() {
		return repository.findAll();
	}

	@PostMapping("/add-contact")
	public ResponseEntity<?> addContact(@RequestBody Contact contact){
		Contact contact1 = repository.save(contact);
		if(contact1 != null)
			return ResponseEntity.ok(contact1);
		else
			return ResponseEntity.badRequest().body("Failed");
	}

	@PostMapping("/delete-contact")
	public ResponseEntity<?> deleteContact(@RequestBody String email){
		Contact contact1 = repository.findByEmail(email);
		contact1.setDeleted(true);
		contact1 = repository.save(contact1);
		if(contact1 != null)
			return ResponseEntity.ok(contact1);
		else
			return ResponseEntity.badRequest().body("Failed");
	}



}
