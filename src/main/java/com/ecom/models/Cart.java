package com.ecom.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	
	
//	@JsonIgnoreProperties({"cart", "user"})
//	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
//	private User user;
	
	
	@JsonIgnoreProperties({"carts", "products"})
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "cart_products_table", 
	joinColumns = {
		@JoinColumn(name="cartId", referencedColumnName = "cart_id")
		
	},
	inverseJoinColumns = {
			@JoinColumn(name="productId", referencedColumnName = "product_id")
	}
	)
	private List<Products> products;
	

}
