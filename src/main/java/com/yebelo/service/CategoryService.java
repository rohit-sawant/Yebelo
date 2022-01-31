package com.yebelo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.yebelo.entity.Category;
import com.yebelo.helper.Helper;
import com.yebelo.repository.CategoryRepository;

public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	 Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	 
	 List<Category> saveAllCategory(List<Category> categories) {
		 return this.categoryRepository.saveAll(categories);
	 }
	 
	 void deleteCategoryById(int id) {
		  this.categoryRepository.deleteById(id);
	 }
	 
	 Optional<Category> getCategoryById(int id) {
		 return this.categoryRepository.findById(id);
	 }
	 
	 List<Category> getAllCategory(){
		 return this.categoryRepository.findAll();
	 }
	 
	 ResponseEntity<?> fetchNextNumber(Category c){
		 try {

			 Category category = this.categoryRepository.findByCategoryCode(c.getCategoryCode());
			 int oldValue = category.getValue();
			 category.setValue(Helper.fetchNextNumber(oldValue));
			 this.categoryRepository.save(category);
			 return ResponseEntity.ok(Map.of("old value",oldValue,"new value",category.getValue()));
		 }
		 catch (Exception e) {
			 
		}
		 return ResponseEntity.ok(Map.of("message","error!! something went wrong","status","error"));
	 }
}
