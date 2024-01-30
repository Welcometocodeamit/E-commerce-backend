package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.models.Products;
import com.ecom.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired ProductService productService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createProduct(@org.springframework.web.bind.annotation.RequestBody Products pro){
	    System.out.println("Received product: " + pro);
	    System.out.println(pro.getProduct_name());
//	    Products p = new Products();
//	    p.setPname("aehg");
//	    p.setPdesc("akjhe");
//	    p.setPprice(5425);
//	    p.setCategory(null);
	    return productService.createProduct(pro);
	}
	
	
	

}
