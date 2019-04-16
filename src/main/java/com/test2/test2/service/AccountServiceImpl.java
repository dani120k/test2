package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl {

    @Autowired
    private AccountService repository;

    public List<Account> getAll() {
        return (List<Account>)repository.findAll();
    }

    public Account add(Account product){
        try {
            return repository.save(product);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Account product){
        repository.delete(product);
    }

    public Account findByName(String name){
        return repository.findByName(name);
    }
}