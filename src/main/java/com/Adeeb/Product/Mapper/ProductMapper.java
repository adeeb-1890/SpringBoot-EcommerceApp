package com.Adeeb.Product.Mapper;

import com.Adeeb.Product.DTO.ProductDTO;
import com.Adeeb.Product.Entity.Category;
import com.Adeeb.Product.Entity.Product;

public class ProductMapper {

    // entity to DTO
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // DTO to entity
    public static Product toProductEntity(ProductDTO productDTO , Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;

    }
}
