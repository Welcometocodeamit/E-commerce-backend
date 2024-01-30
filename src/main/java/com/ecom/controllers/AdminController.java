package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.services.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired AdminServices adminServices;
	
	@PutMapping("/product/{productId}/category/{categoryId}")
	public ResponseEntity<?> assignCategory(@PathVariable int productId, @PathVariable int categoryId){
		return adminServices.assignCatergory(productId, categoryId);
	}

}
