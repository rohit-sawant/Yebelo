package com.yebelo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.yebelo.entity.Category;
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
	 
}
