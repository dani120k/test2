package com.test2.test2.service;

import com.test2.test2.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl {

    @Autowired
    private PriceService repository;

    public List<Price> getAll() {
        return (List<Price>)repository.findAll();
    }

    public Price add(Price product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Price product){
        repository.delete(product);
    }

}