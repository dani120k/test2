package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Account;
import com.test2.test2.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
