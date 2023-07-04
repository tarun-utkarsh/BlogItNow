package com.first.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.first.blog.payloads.CategoryDto;

@Service
public interface CategoryService {
	
	//create
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getSingleCategory(Integer categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategory();

}
