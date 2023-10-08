package com.igorborba.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.igorborba.ecommerce.entities.Category;
import com.igorborba.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public Category findById(Integer id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElse(null);
	}
}
