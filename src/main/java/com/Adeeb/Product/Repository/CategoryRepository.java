package com.Adeeb.Product.Repository;

import com.Adeeb.Product.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
