package com.test2.test2.service;

import com.test2.test2.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductService extends CrudRepository<Product, Long> {
}
