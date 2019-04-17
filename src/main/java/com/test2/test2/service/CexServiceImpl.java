package com.test2.test2.service;

import com.test2.test2.model.Category;
import com.test2.test2.model.Cex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CexServiceImpl {

    @Autowired
    private CexService repository;

    public List<Cex> getAll() {
        return (List<Cex>)repository.findAll();
    }

    public Cex add(Cex product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Cex product){
        repository.delete(product);
    }

    public Cex findByName(String name){
        System.out.println(name);
        return repository.findByName(name);
    }
}