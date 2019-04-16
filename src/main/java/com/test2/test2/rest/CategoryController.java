package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Category;
import com.test2.test2.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/getAll")
    public String getAll(){
        return new Gson().toJson(categoryService.getAll());
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/add")
    public String add(@RequestBody Category category){
        System.out.println(category.toString());
        categoryService.add(category);
        return new Gson().toJson(categoryService.getAll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/delete")
    public String delete(@RequestParam String name){
        Category forDelete = categoryService.findByName(name);
        categoryService.deletePerson(forDelete);
        return new Gson().toJson(forDelete);
    }
}
