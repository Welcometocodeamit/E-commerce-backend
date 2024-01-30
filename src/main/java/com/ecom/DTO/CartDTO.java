package com.ecom.DTO;

import java.util.List;

import com.ecom.models.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	
	private int cartId;
	
	private List<ProductsDTO> products;
	

}
