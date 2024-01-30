package com.ecom.DTO;


import java.util.Optional;

import com.ecom.models.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
	
	private Optional<Products> product;
	
	private Integer quantity;

}
