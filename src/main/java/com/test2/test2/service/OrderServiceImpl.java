package com.test2.test2.service;

import com.test2.test2.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderService repository;

    public List<Order> getAll() {
        return (List<Order>)repository.findAll();
    }

    public Order add(Order product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Order product){
        repository.delete(product);
    }
}