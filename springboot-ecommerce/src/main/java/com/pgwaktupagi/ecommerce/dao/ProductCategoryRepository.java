package com.pgwaktupagi.ecommerce.dao;

import com.pgwaktupagi.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:5173/")
@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}