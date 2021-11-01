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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Cart;
import tn.esprit.spring.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@GetMapping("/get") //GET
	public List<Cart> findAll() {
		return cartService.get();
	}

	@PostMapping(value = "/save") //POST
	public ResponseEntity<Cart> post(@RequestBody Cart cart) {

		return new ResponseEntity<>(cartService.save(cart), HttpStatus.OK);
	}

	@GetMapping("/get/{id}") //GET BY ID
	public Optional<Cart> getById(@PathVariable Long id) {
		return cartService.getById(id);
	}

	@PutMapping("/put/{id}") //UPFATE
	public ResponseEntity<Cart> update(@PathVariable(value = "id") Long id, @RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.update(id, cart), HttpStatus.OK);
	}

	//@DeleteMapping("/delete/{id}") //DELETE BY ID
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(cartService.delete(id), HttpStatus.OK);

		
	}

}
