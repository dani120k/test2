package com.test2.test2.service;

import com.test2.test2.model.Category;
import com.test2.test2.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryService repository;

    public List<Category> getAll() {
        return (List<Category>)repository.findAll();
    }

    public Category add(Category product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Category product){
        repository.delete(product);
    }

    public Category findByName(String name){
        System.out.println(name);
        return repository.findOneByName(name);
    }
}