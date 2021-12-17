package com.techgeeknext.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgeeknext.entity.CategoryDao;
import com.techgeeknext.entity.SubCategoryDao;
import com.techgeeknext.model.CategoryDto;
import com.techgeeknext.model.SubCategoryDto;
import com.techgeeknext.service.CategoryService;

@RestController()
@RequestMapping("/admin")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public BodyBuilder saveCategory(@RequestBody CategoryDto category) throws Exception {
		CategoryDao newcategory=categoryService.saveCategory(category);
		return ResponseEntity.created(new URI("/admin/category/"+newcategory.getId()));
	}
	
	@PatchMapping("/category")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDto category) throws Exception {
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getCategory(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(categoryService.getCategoryDetails(id));
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id) throws Exception {
		categoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete Successful.");
	}
	
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategories() throws Exception {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
	
	
	@PostMapping("/subcategory")
	public BodyBuilder saveSubCategory(@RequestBody SubCategoryDto subCategory) throws Exception {
		SubCategoryDao newcategory=categoryService.saveSubCategory(subCategory);
		return ResponseEntity.created(new URI("/admin/category/"+newcategory.getId()));
	}
	
	@PatchMapping("/subcategory")
	public ResponseEntity<?> updateSubCategory(@RequestBody SubCategoryDto subCategory) throws Exception {
		return ResponseEntity.ok(categoryService.updateSubCategory(subCategory));
	}
	
	@GetMapping("/subcategory/{id}")
	public ResponseEntity<?> getSubCategory(@PathVariable long id) throws Exception {
		return ResponseEntity.ok(categoryService.getSubCategoryDetails(id));
	}
	
	@DeleteMapping("/subcategory/{id}")
	public ResponseEntity<?> deleteSubCategory(@PathVariable long id) throws Exception {
		categoryService.deleteSubCategory(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete Successful.");
	}
	
	@GetMapping("/subcategory")
	public ResponseEntity<?> getAllSubCategories() throws Exception {
		return ResponseEntity.ok(categoryService.getAllSubCategories());
	}	
	
}
