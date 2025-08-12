package com.Adeeb.Product.DTO;

import com.Adeeb.Product.Entity.Product;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
