package com.test2.test2.service;

import com.test2.test2.model.Category;
import com.test2.test2.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface CategoryService extends CrudRepository<Category, Long> {
    Category findOneByName(String name);
}
