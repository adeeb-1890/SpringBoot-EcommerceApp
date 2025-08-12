package com.Adeeb.Product.Mapper;

import com.Adeeb.Product.DTO.CategoryDTO;
import com.Adeeb.Product.Entity.Category;



public class CategoryMapper {

    //    categoryDTO -> category entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }


    // category entity to categoryDTO
    public static CategoryDTO toCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        if (category.getProducts() != null) {
            categoryDTO.setProducts(
                    category.getProducts()
                            .stream()
                            .map(ProductMapper::toProductDTO)
                            .toList()
            );
            return categoryDTO;

        }
        return categoryDTO;
    }
}
