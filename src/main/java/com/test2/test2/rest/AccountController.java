package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Account;
import com.test2.test2.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/getById")
    public String getById(@RequestParam Long id){
        Account account = accountService.findById(id);
        return new Gson().toJson(account);
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody Account account){
        accountService.add(account);
        return new Gson().toJson(account);
    }

    @GetMapping(value = "/getByType")
    public String get(@RequestParam Long type){
        List<Account> accounts = accountService.findByType(type);
        return new Gson().toJson(accounts);
    }

}
