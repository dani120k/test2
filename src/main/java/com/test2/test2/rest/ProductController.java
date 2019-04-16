package com.test2.test2.rest;


import com.google.gson.Gson;
import com.test2.test2.model.Category;
import com.test2.test2.model.Product;
import com.test2.test2.service.CategoryService;
import com.test2.test2.service.CategoryServiceImpl;
import com.test2.test2.service.OrderServiceImpl;
import com.test2.test2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll(@RequestParam String name){
        System.out.println(name);
        Long id = categoryService.findByName(name).getId();
        List<Product> products = productService.getByCategoryId(id);
        return new Gson().toJson(products);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Product product, @RequestParam String name){
        Category category = categoryService.findByName(name);
        product.setCategory(category.getId());
        Product addedProduct = productService.add(product);
        return new Gson().toJson(productService.getByCategoryId(category.getId()));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/add")
    public String deleteProduct(@RequestParam String name){
        return "delete";
    }




}
