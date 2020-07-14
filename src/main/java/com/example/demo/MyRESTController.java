package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MyRESTController {

	@Autowired
	ContactRepository repository;

	@Autowired
	PlaceRepository placeRepository;

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
	public ResponseEntity<?> deleteContact(@RequestParam String email){
		Contact contact1 = repository.findByEmail(email);
		contact1.setDeleted(true);
		contact1 = repository.save(contact1);
		if(contact1 != null)
			return ResponseEntity.ok(contact1);
		else
			return ResponseEntity.badRequest().body("Failed");
	}

	@GetMapping("/contact-for-place")
	public Set<Contact> findContactsForPlace(@RequestParam String place){
		Place place1 = placeRepository.findByPlaceName(place);
		return place1.getContact();
	}

	



}
