package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.CartRepository;

@Service
@Transactional
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public List<Cart> get() // GET
	{
		return (List<Cart>) cartRepository.findAll();
	}

	public Optional<Cart> getById(Long id) // GET BY ID
	{
		return cartRepository.findById(id);
	}

	
	public Cart save(Cart cart) { //POST
		return cartRepository.save(cart);
	}

	public Cart update(long id, Cart cart) { // UPDATE
		Cart new_cart = cartRepository.findById(id);
		new_cart.setSize(cart.getSize());
		new_cart.setDescription(cart.getDescription());
		return cartRepository.save(new_cart);
	}

	public String delete(Long id) { // DELETE BY ID
		try {
			cartRepository.deleteById(id);
			return "Deleted!";
		} catch (Exception e) {
			return "Error!";
		}

	}

	public String deleteAll() { // DELETE ALL
		try {
			cartRepository.deleteAll();
			return "Deleted!";
		} catch (Exception e) {
			return "Error!";
		}
	}

}
