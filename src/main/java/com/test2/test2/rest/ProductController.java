package com.test2.test2.rest;


import com.google.gson.Gson;
import com.test2.test2.model.Product;
import com.test2.test2.service.ProductServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll(){
        List<Product> products = productService.getAll();
        return new Gson().toJson(products);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Product product){
        System.out.println(product.getName());
        Product addedProduct = productService.add(product);
        if (addedProduct !=null)
            return new Gson().toJson(addedProduct);
        else
            return new Gson().toJson("Product with this name is already exist");
    }



}
