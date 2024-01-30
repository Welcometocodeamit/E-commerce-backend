package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.services.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired CartService cartService;
	
//	Get cart by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartById(@PathVariable int id){
		return cartService.getCartById(id);
	}
	
//	Add products to cart
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProductToCart(@RequestParam int cartId, @RequestParam int productId, @RequestParam int quantity){
		return cartService.addProductsToCart(cartId, productId, quantity);
	}
	
//	Get carts
	@GetMapping("")
	public ResponseEntity<?> getAllCarts(){
		return cartService.getAllCarts();
	}

}
