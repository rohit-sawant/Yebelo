package com.yebelo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yebelo.entity.Category;
import com.yebelo.helper.Helper;
import com.yebelo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	 public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	 
	 public List<Category> saveAllCategory(List<Category> categories) {
		 return this.categoryRepository.saveAll(categories);
	 }
	 
	 public void deleteCategoryById(int id) {
		  this.categoryRepository.deleteById(id);
	 }
	 
	 public Optional<Category> getCategoryById(int id) {
		 return this.categoryRepository.findById(id);
	 }
	 
	 public List<Category> getAllCategory(){
		 return this.categoryRepository.findAll();
	 }
	 
	 public ResponseEntity<?> fetchNextNumber(Category c){
		 try {

			 Category category = this.categoryRepository.findByCategoryCode(c.getCategoryCode());
			 int oldValue = category.getValue();
			 category.setValue(Helper.fetchNextNumber(oldValue));
			 this.categoryRepository.save(category);
			 return ResponseEntity.ok(Map.of("old value",oldValue,"new value",category.getValue()));
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		}
		 return ResponseEntity.ok(Map.of("message","error!! something went wrong","status","error"));
	 }
}
