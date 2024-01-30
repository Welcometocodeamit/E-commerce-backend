package com.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.models.Products;

public interface productrepository extends JpaRepository<Products, Integer> {
	
	

}
