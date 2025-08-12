package com.Adeeb.Product.Controller;

import com.Adeeb.Product.DTO.CategoryDTO;
import com.Adeeb.Product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;
    // get all categories
    // create category
    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(service.createCategory(categoryDTO) , HttpStatus.CREATED);
    }
    // get category by Id


}
