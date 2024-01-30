package com.ecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.models.Products;
import com.ecom.repositories.productrepository;

@Service
public class ProductService {
	
	@Autowired productrepository productrepository;
	
	
//	get all products
	public ResponseEntity<?> getAllProducts(){
		List<Products> allProducts =productrepository.findAll();
		
		if(allProducts.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found add some");
		}else {
			return new ResponseEntity<>(allProducts, HttpStatus.FOUND);
		}
	}
	
//	get product by id
	public ResponseEntity<?> getProductById(int id){
		Optional<Products> foundProduct=productrepository.findById(id);
		
		if(foundProduct.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with given id not found");
		}
		
		return new ResponseEntity<>(foundProduct, HttpStatus.FOUND);
		
	}
	
//	delete product by id
	public ResponseEntity<?> deleteProductById(int id){
		getProductById(id);
		productrepository.deleteById(id);
		return new ResponseEntity<>("Product with given id "+id+" is deleted", HttpStatus.OK);
	}
	
//	post product
	public ResponseEntity<?> createProduct(Products product){
		
		Products addedProduct=productrepository.save(product);
		if(addedProduct == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not added");
		}
		return new ResponseEntity<>(addedProduct, HttpStatus.OK);
	}

}
