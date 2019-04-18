package com.test2.test2.service;

import com.test2.test2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductService repository;

    public List<Product> getAll() {
        return (List<Product>)repository.findAll();
    }

    public Product add(Product product){
        return repository.save(product);
    }

    public Product update(Product product){
        return repository.save(product);
    }

    public void deletePerson(Product product){
        repository.delete(product);
    }

    public List<Product> getByCategoryId(Long id){
        return repository.findAllByCategory(id);
    }

    public Product findByName(String name){return repository.findByName(name);}

}