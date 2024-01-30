package com.ecom.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.models.Category;
import com.ecom.models.Products;
import com.ecom.repositories.categoryRepository;
import com.ecom.repositories.productrepository;

@Service
public class AdminServices {
	
	@Autowired productrepository productrepository;
	@Autowired categoryRepository categoryRepository;
	
	public ResponseEntity<?> assignCatergory(int pid, int cid) {
		Products foundProduct=productrepository.findById(pid).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with given id not found");
		});
		
		Category foundCategory=categoryRepository.findById(cid).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with given id not found");
		});
		
		foundProduct.setCategory(foundCategory);
		productrepository.save(foundProduct);

		return new ResponseEntity<>("Category " +foundCategory.getCategory_name()+" is assigned to product "+foundProduct.getProduct_name() , HttpStatus.OK);
		
	}

}
