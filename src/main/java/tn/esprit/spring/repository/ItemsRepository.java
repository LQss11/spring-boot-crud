package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Cart;
import tn.esprit.spring.entity.Items;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {

	Items findById(long id);
	List<Items> findByCart(Cart cart);
	//List<Items> findByName(Items items,Sort sort);
}
