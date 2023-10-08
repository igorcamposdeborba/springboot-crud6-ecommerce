package com.igorborba.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorborba.ecommerce.entities.Category;
import com.igorborba.ecommerce.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value="{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
}