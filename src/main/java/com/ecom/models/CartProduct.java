package com.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_products_table")
public class CartProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double cart_item_id;
	
	private int cartId;
	
	private int productId;
	
	@Column(nullable = true)
	private Integer product_quantity;

}
