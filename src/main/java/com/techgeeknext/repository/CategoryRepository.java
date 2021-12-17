package com.techgeeknext.repository;
import org.springframework.data.repository.CrudRepository;

import com.techgeeknext.entity.CategoryDao;
public interface CategoryRepository extends CrudRepository<CategoryDao, Integer> {
	CategoryDao findById(long id);
    boolean existsByName(String name);
	void deleteById(long id);
}