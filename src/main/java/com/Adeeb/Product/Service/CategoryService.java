package com.Adeeb.Product.Service;

import com.Adeeb.Product.DTO.CategoryDTO;
import com.Adeeb.Product.Entity.Category;
import com.Adeeb.Product.Mapper.CategoryMapper;
import com.Adeeb.Product.Repository.CategoryRepository;
import com.Adeeb.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // get all categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper :: toCategoryDTO).toList();
    }

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No such cateogry exists"));
        return CategoryMapper.toCategoryDTO(category);
    }

    // delete category
    public String deleteCategory(Long id){
        categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found:"));
        categoryRepository.deleteById(id);
        return "successfully deleted: ";
    }

}
