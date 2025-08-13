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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // create Product
    public ProductDTO createProduct(ProductDTO productDTO){
        // check if category exits or not
        Category category =  categoryRepository.findById(productDTO.getCategory_id()).
                orElseThrow(() -> new RuntimeException("Category not found"));

        Product product=  ProductMapper.toProductEntity(productDTO , category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
    // get product by id
    public ProductDTO getProductById(Long id) {
        // check if product exists or not
        Product product=  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    // delete by Id
    public String deleteProductById(Long id) {
        Product product=  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
        return "Product Deleted successfully";
    }

    // Update product
    public ProductDTO updateProduct(Long id , ProductDTO productDTO) {
        // check if the category exits or not
        Product product=  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        Category category =  categoryRepository.findById(productDTO.getCategory_id()).orElseThrow(() -> new RuntimeException(("category mismatch")));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }



}
