package com.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.models.CartProduct;
import java.util.List;


@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Double>{
	
	List<CartProduct> findByCartId(int cart_id);
	
	 CartProduct findByCartIdAndProductId(int cartId, int productId);
	 
	 void deleteByCartId(int cartId);

}
