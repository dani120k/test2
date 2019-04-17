package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Cex;
import com.test2.test2.service.CexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cex")
@CrossOrigin(origins = "localhost:3000")
public class CexController {
    @Autowired
    private CexServiceImpl cexService;

    @PostMapping(value = "/add")
    public String addNewCex(@RequestBody Cex cex){
        cexService.add(cex);
        return new Gson().toJson(cex);
    }

    @GetMapping(value = "/getAll")
    public String getAll(){
        return new Gson().toJson(cexService.getAll());
    }
}
