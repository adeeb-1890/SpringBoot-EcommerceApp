package com.Adeeb.Product.Controller;

import com.Adeeb.Product.DTO.CategoryDTO;
import com.Adeeb.Product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;

    // get all categories
    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories(){
        return service.getAllCategories();
    }
    // create category
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(service.createCategory(categoryDTO) , HttpStatus.CREATED);
    }

    // get category by Id
    @GetMapping("category/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(service.getCategoryById(id) , HttpStatus.FOUND);
    }
    // Delete category
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable Long id){
        return service.deleteCategory(id);
    }

}
