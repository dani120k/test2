package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.CexOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CexOrderServiceImpl {

    @Autowired
    private CexOrderService repository;

    public List<CexOrder> getAll() {
        return (List<CexOrder>)repository.findAll();
    }

    public CexOrder add(CexOrder product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(CexOrder product){
        repository.delete(product);
    }

    public CexOrder findByName(String name){
        return repository.findByName(name);
    }

    public List<CexOrder> findById(Long id){return repository.findAllByProductid(id);}
}