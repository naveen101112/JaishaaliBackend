package com.techgeeknext.service;

import com.techgeeknext.entity.CategoryDao;
import com.techgeeknext.entity.SubCategoryDao;
import com.techgeeknext.model.CategoryDto;
import com.techgeeknext.model.SubCategoryDto;
import com.techgeeknext.repository.CategoryRepository;
import com.techgeeknext.repository.SubCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private SubCategoryRepository subCategoryRepo;

	public CategoryDao saveCategory(CategoryDto category) {
		CategoryDao newCategory = new CategoryDao();
		newCategory.setName(category.getName());
		return categoryRepo.save(newCategory);
	}
	
	public CategoryDao getCategoryDetails(long id) {
		return categoryRepo.findById(id);
	}
	
	public Iterable<CategoryDao> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	public CategoryDao updateCategory(CategoryDto category) {
		CategoryDao newCategory = new CategoryDao();
		newCategory.setName(category.getName());
		return categoryRepo.save(newCategory);
	}
	
	@Transactional
	public void deleteCategory(long id) {
		categoryRepo.deleteById(id);
	}
	
	public boolean userExist(String username) {
		return true;
	}
	
	public SubCategoryDao saveSubCategory(SubCategoryDto subCategory) {
		SubCategoryDao newSubCategory = new SubCategoryDao();
		newSubCategory.setCategoryId(subCategory.getCategoryId());
		newSubCategory.setName(subCategory.getName());
		newSubCategory.setPrice(subCategory.getPrice());
		return subCategoryRepo.save(newSubCategory);
	}
	
	public SubCategoryDao getSubCategoryDetails(long id) {
		return subCategoryRepo.findById(id);
	}
	
	public Iterable<SubCategoryDao> getAllSubCategories() {
		return subCategoryRepo.findAll();
	}
	
	public SubCategoryDao updateSubCategory(SubCategoryDto subCategory) {
		SubCategoryDao newSubCategory = new SubCategoryDao();
		newSubCategory.setCategoryId(subCategory.getCategoryId());
		newSubCategory.setName(subCategory.getName());
		newSubCategory.setPrice(subCategory.getPrice());
		return subCategoryRepo.save(newSubCategory);
	}
	
	@Transactional
	public void deleteSubCategory(long id) {
		categoryRepo.deleteById(id);
	}
	
}