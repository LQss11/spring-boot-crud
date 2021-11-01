package tn.esprit.spring.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CART")
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int size;
	private String description;

	@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "cart")
	private Set<Items> items;

	public Cart() {
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", size=" + size + ", description=" + description + ", items=" + items + "]";
	}

	public Cart(Long id, int size, String description) {
		super();
		this.id = id;
		this.size = size;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}