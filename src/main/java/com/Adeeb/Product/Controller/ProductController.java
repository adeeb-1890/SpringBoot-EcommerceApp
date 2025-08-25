package com.Adeeb.Product.Controller;

import com.Adeeb.Product.DTO.ProductDTO;
import com.Adeeb.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    // create Product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO) , HttpStatus.CREATED);
    }

    // fetch product by Product id
    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // delete product by product id
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/product/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

    // update product
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, ProductDTO productDTO){

        return productService.updateProduct(id , productDTO);
    }

}
