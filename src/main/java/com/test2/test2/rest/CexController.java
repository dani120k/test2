package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Account;
import com.test2.test2.model.Cex;
import com.test2.test2.service.AccountServiceImpl;
import com.test2.test2.service.CexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cex")
@CrossOrigin(origins = "http://localhost:3000")
public class CexController {
    @Autowired
    private CexServiceImpl cexService;

    @Autowired
    private AccountServiceImpl accountService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/add")
    public String addNewCex(@RequestBody Cex cex, @RequestParam String name, @RequestParam String password){
        System.out.println(cex.toString());
        System.out.println(name + " " + password);
        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        account.setType(1L);
        Account added = accountService.add(account);
        cex.setAccount(added);
        cexService.add(cex);
        return new Gson().toJson(cex);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/getAll")
    public String getAll(){
        for(Cex cex:cexService.getAll())
            System.out.println(cex.toString());
        return new Gson().toJson(cexService.getAll());
    }
}
