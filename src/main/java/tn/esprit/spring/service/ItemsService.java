package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.ItemsRepository;

@Service
@Transactional
public class ItemsService {

	@Autowired
	ItemsRepository itemstRepository;
	
	@Autowired
	CartRepository cartRepository;
	public List<Items> get() // GET
	{
		return (List<Items>) itemstRepository.findAll();
	}

	public Optional<Items> getById(Long id) // GET BY ID
	{
		return itemstRepository.findById(id);
	}

	public List<Items> getByCartId(Long id) // GET BY CART ID
	{
		Cart cart = cartRepository.findById(id).get();
		return itemstRepository.findByCart(cart);
	}
	
	public Items save(Items items) { //POST
		Cart cart = cartRepository.findById(items.getCart_id()).get();
		items.setCart(cart);
		return itemstRepository.save(items);
	}

	public Items update(long id, Items items) { // UPDATE
		Items new_items  = itemstRepository.findById(id);

		new_items.setDescription(items.getDescription());
		new_items.setName(items.getName());
		if(items.getCart_id()!=null) {
			Cart cart = cartRepository.findById(items.getCart_id()).get();
			new_items.setCart(cart);
		}

		return itemstRepository.save(new_items);
	}

	public String delete(Long id) { // DELETE BY ID
		try {
			itemstRepository.deleteById(id);
			return "Deleted!";
		} catch (Exception e) {
			return "Error!";
		}

	}

	public String deleteAll() { // DELETE ALL
		try {
			itemstRepository.deleteAll();
			return "Deleted!";
		} catch (Exception e) {
			return "Error!";
		}
	}

}
