package com.yebelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yebelo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findByCategoryCode(int i);
}
