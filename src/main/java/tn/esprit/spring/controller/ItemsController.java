package tn.esprit.spring.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Items;
import tn.esprit.spring.service.ItemsService;

@RestController
@RequestMapping(value = "/items")
public class ItemsController {

	@Autowired
	ItemsService itemsService;

	@GetMapping("/get") //GET
	public List<Items> findAll() {
		return itemsService.get();
	}

	@GetMapping("/getbycart/{id}") //GET BY CART ID
	public List<Items> getByCartId(@PathVariable Long id) {
		return itemsService.getByCartId(id);
	}

	@PostMapping(value = "/save") //POST
	public ResponseEntity<Items> post(@RequestBody Items items) {
		return new ResponseEntity<>(itemsService.save(items), HttpStatus.OK);
	}

	@GetMapping("/get/{id}") //GET BY ID
	public Optional<Items> getById(@PathVariable Long id) {
		return itemsService.getById(id);
	}

	@PutMapping("/put/{id}") //UPDATE
	public ResponseEntity<Items> update(@PathVariable(value = "id") Long id, @RequestBody Items items) {
		return new ResponseEntity<>(itemsService.update(id, items), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}") //DELETE BY ID
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(itemsService.delete(id), HttpStatus.OK);
	}

}