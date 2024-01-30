package com.ecom.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	
	@Column(nullable = false, unique = true)
	@Size(min=3, max=30)
	private String category_name;
	
	@Column(nullable = false)
	@Size(min = 3)
	private String category_desc;
	
	@JsonIgnoreProperties({"category", "products"})
	@OneToMany(mappedBy = "category", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<Products> products;
	
	

	

}
