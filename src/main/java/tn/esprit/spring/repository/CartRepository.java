package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Cart;
public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findById(long id);
	//Cart findById(int id);
}
