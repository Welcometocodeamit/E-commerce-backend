package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	

}
