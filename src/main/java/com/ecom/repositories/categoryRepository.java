package com.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.models.Category;

@Repository
public interface categoryRepository extends JpaRepository<Category, Integer> {
	
	

}
