package com.test2.test2.rest;


import com.google.gson.Gson;
import com.test2.test2.model.Price;
import com.test2.test2.model.Product;
import com.test2.test2.service.PriceServiceImpl;
import com.test2.test2.service.ProductServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    PriceServiceImpl priceService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll(){
        Date date = new Date();

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

    @RequestMapping(method = RequestMethod.DELETE, value = "/add")
    public String deleteProduct(@RequestParam String name){
        return "delete";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllPrices")
    public String getAllPrices(@RequestParam String date){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date findDate = simpleDateFormat.parse(date);
            List<Product> products = productService.getAll();
            for(Product p: products){
                Price price = priceService.findPriceForDate(findDate, p.getId());
                System.out.println(p.getName() + " " + price.getPrice());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "hi";
    }



}
