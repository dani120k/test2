package com.test2.test2.service;

import com.test2.test2.model.Order;
import com.test2.test2.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl {

    @Autowired
    private OrderItemService repository;

    public List<OrderItem> getAll() {
        return (List<OrderItem>)repository.findAll();
    }

    public OrderItem add(OrderItem product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(OrderItem product){
        repository.delete(product);
    }
}