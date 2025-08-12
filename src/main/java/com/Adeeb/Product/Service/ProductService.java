package com.Adeeb.Product.Service;

import com.Adeeb.Product.DTO.ProductDTO;
import com.Adeeb.Product.Entity.Category;
import com.Adeeb.Product.Entity.Product;
import com.Adeeb.Product.Mapper.ProductMapper;
import com.Adeeb.Product.ProductApplication;
import com.Adeeb.Product.Repository.CategoryRepository;
import com.Adeeb.Product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // create Product
    public ProductDTO createProduct(ProductDTO productDTO){
        // check if category exits or not
        Category category=  categoryRepository.findById(productDTO.getCategory_id()).
                orElseThrow(() -> new RuntimeException("Category not found"));

        Product product=  ProductMapper.toProductEntity(productDTO , category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
}
