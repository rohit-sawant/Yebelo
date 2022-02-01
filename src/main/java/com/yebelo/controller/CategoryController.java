package com.yebelo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yebelo.entity.Category;
import com.yebelo.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable("id") int id) {
		Optional<Category> category = this.categoryService.getCategoryById(id);
		if(category.isPresent()) {

			return ResponseEntity.ok(category);
		}
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/category")
	public ResponseEntity<?> getCategories() {
		List<Category> category = this.categoryService.getAllCategory();
		return ResponseEntity.ok(category);
	}
	@PostMapping("/category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		try {
			this.categoryService.saveCategory(category);
			return ResponseEntity.ok().build();
		}
		catch (DataIntegrityViolationException ed) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","category already exist","status","error"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		try {
			this.categoryService.deleteCategoryById(id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().build();
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") int id , @RequestBody Category category){
		try {
			category.setId(id);
			this.categoryService.saveCategory(category);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().build();
	}
	
	@PostMapping("/FetchNextNumber")
	public ResponseEntity<?> fetchNextNumber(@RequestBody Category category){
		return this.categoryService.fetchNextNumber(category);
	}
	
	
}
