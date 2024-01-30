package com.ecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.models.Category;
import com.ecom.repositories.categoryRepository;

@Service
public class CategoryService {
	
	@Autowired categoryRepository categoryRepository;

	public ResponseEntity<?> getAllCategory(){
		List<Category> allCategory=categoryRepository.findAll();
		if(allCategory.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found in database");
		}else {
			
			return new ResponseEntity<>(allCategory, HttpStatus.FOUND);
		}
	}

}
