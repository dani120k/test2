package com.test2.test2.service;

import com.test2.test2.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProductService extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE product.name = ?1", nativeQuery = true)
    Product findByName(String name);
}
