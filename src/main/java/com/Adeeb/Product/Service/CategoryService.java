package com.Adeeb.Product.Service;

import com.Adeeb.Product.DTO.CategoryDTO;
import com.Adeeb.Product.Entity.Category;
import com.Adeeb.Product.Mapper.CategoryMapper;
import com.Adeeb.Product.Repository.CategoryRepository;
import com.Adeeb.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
}
