package com.techgeeknext.repository;
import org.springframework.data.repository.CrudRepository;

import com.techgeeknext.entity.SubCategoryDao;
public interface SubCategoryRepository extends CrudRepository<SubCategoryDao, Integer> {
	SubCategoryDao findById(long id);
    boolean existsByName(String name);
	void deleteById(long id);
}