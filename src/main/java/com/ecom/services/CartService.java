package com.ecom.services;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecom.DTO.CartDTO;
import com.ecom.DTO.ProductsDTO;
import com.ecom.models.Cart;
import com.ecom.models.CartProduct;
import com.ecom.models.Products;
import com.ecom.repositories.CartProductRepository;
import com.ecom.repositories.CartRepository;
import com.ecom.repositories.productrepository;

@Service
public class CartService {
	
	@Autowired CartRepository cartRepository;
	@Autowired productrepository productrepository;
	@Autowired CartProductRepository cartProductRepository;
	
//	get cart by id 
	public ResponseEntity<?> getCartById(int id){
		Cart foundCart=cartRepository.findById(id).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart with given id not found");
		});
		
		List<Products> productList=foundCart.getProducts();
		CartDTO cartdto = new CartDTO();
		cartdto.setCartId(id);
		productList.forEach(product->{
			CartProduct cartProduct=cartProductRepository.findByCartIdAndProductId(id, product.getProduct_id());
			ProductsDTO productDTO = new ProductsDTO();
			productDTO.setProduct(productrepository.findById(cartProduct.getProductId()));
			productDTO.setQuantity(cartProduct.getProduct_quantity());
			if (cartdto.getProducts() == null) {
		        cartdto.setProducts(new ArrayList<>());
		    }

		    cartdto.getProducts().add(productDTO);
		});
		

		
		return new ResponseEntity<>(cartdto, HttpStatus.OK);
	}
	
//	Add products to cart
	public ResponseEntity<?> addProductsToCart(int cartId, int productId, int quantity){
		
		
		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		  
//		 if cart iteam is already asigned to users cart
		  if(cartProduct != null){
//			  CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
			  Integer q=cartProduct.getProduct_quantity();
			  cartProduct.setProduct_quantity(q+quantity);
			  cartProductRepository.save(cartProduct);
			  return new ResponseEntity<>("Product already exist in cart", HttpStatus.OK);
		  }
		  
//		  If product is not present in cart
		  CartProduct cp = new CartProduct();
		  cp.setCartId(cartId);
		  cp.setProductId(productId);
		  cp.setProduct_quantity(quantity);
		  cartProductRepository.save(cp);
		  
		return new ResponseEntity<>(cp, HttpStatus.OK);
	}

//	Get all carts
	public ResponseEntity<?> getAllCarts(){
		List<Cart> carts = cartRepository.findAll();
		return new ResponseEntity<>(carts, HttpStatus.OK);
	}

}
