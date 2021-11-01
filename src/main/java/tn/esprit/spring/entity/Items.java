package tn.esprit.spring.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ITEMS")
public class Items implements Serializable {
    
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
	@Temporal(TemporalType.DATE)
    private Date expiration;

    /*
     * FOREIGN KEY BEGIN
     */
    


	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
    
    
    @Transient
    private Long cart_id;
	
	public Long getCart_id() {
		return cart_id;
	}

    /*
     * FOREIGN KEY END
     */
	
    public Items() {}

 
    
	public Items(Long id, String name, String description, Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cart = cart;
	}










	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", cart=" + cart + "]";
	}


	

	
    public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
    


}