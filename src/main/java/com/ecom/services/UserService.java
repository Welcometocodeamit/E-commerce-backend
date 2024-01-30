package com.ecom.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.DTO.CartDTO;
import com.ecom.DTO.ProductsDTO;
import com.ecom.DTO.UserDTO;
import com.ecom.models.Cart;
import com.ecom.models.CartProduct;
import com.ecom.models.Products;
import com.ecom.models.User;
import com.ecom.repositories.CartProductRepository;
import com.ecom.repositories.CartRepository;
import com.ecom.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired UserRepository repository;
	@Autowired CartRepository cartRepository;
	@Autowired CartService cartService;
	@Autowired CartProductRepository cartProductRepository;
	
//	get user by id
	public ResponseEntity<?> getUserById(int id ){
	  User foundUser=repository.findById(id).orElseThrow(()->{
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with given id not found");
	  });
	  
	  UserDTO userDTO = new UserDTO();
	  userDTO.setUserName(foundUser.getUser_name());
	  userDTO.setUserId(foundUser.getUser_id());
//	  userDTO.getCartDTO().setCartId(foundUser.getCart().getCart_id());
	  
	  ResponseEntity<?> re =cartService.getCartById(foundUser.getCart().getCart_id());
	  CartDTO cartDTO=(CartDTO) re.getBody();
	  userDTO.setCart(cartDTO);
	  return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
//	Add user
	public ResponseEntity<?> addUser(User user){
		
		
		if(user.getCart() == null) {
		Cart cart = new Cart();
 		Cart addedCart=cartRepository.save(cart);	
        user.setCart(addedCart);
		}
		User savedUser=repository.save(user);
		
		if(savedUser == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not added");
		}
		
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
	
//	Delete user by id
	@Transactional
	public ResponseEntity<?> deleteUserById(int id){
		Optional<User> user=repository.findById(id);
		cartRepository.deleteById(user.get().getCart().getCart_id());
		repository.deleteById(id);
		return new ResponseEntity<>("User deleted", HttpStatus.OK);
	}

}
