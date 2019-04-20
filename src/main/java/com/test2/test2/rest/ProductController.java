package com.test2.test2.rest;


import com.google.gson.Gson;
import com.test2.test2.model.Category;
import com.test2.test2.model.Cex;
import com.test2.test2.model.CexOrder;
import com.test2.test2.model.Product;
import com.test2.test2.service.CategoryServiceImpl;
import com.test2.test2.service.CexOrderServiceImpl;
import com.test2.test2.service.CexServiceImpl;
import com.test2.test2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    CexServiceImpl cexService;

    @Autowired
    CexOrderServiceImpl cexOrderService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll(@RequestParam String name){
        System.out.println(name);
        Long id = categoryService.findByName(name).getId();
        List<Product> products = productService.getByCategoryId(id);
        return new Gson().toJson(products);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Product product, @RequestParam String name){
        Category category = categoryService.findByName(name);
        product.setCategory(category.getId());
        Product addedProduct = productService.add(product);
        return new Gson().toJson(productService.getByCategoryId(category.getId()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public String deleteProduct(@RequestParam String name){
        Product product = productService.findByName(name);
        if (product != null)
            productService.deletePerson(product);
        return "hi";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/addCexToProduct")
    public String addCexToProduct(@RequestParam String name, @RequestParam String cex){
        try {
            System.out.println("trrete" + name + " " + cex);
            Cex currCex = cexService.findByName(cex);
            System.out.println(currCex==null);
            Product product = productService.findByName(name);


            System.out.println(product==null);
            CexOrder cexOrder = new CexOrder();
            cexOrder.setCexid(currCex.getId());
            cexOrder.setProductid(product.getId());
            cexOrderService.add(cexOrder);

        }catch (Exception ex){

        }
        return "hi";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String getListOfCex(@RequestParam String name){
        try {
            Product product = productService.findByName(name);
            System.out.println("null" + product.getId());
            List<CexOrder> cexOrders = cexOrderService.findById(product.getId());
            List<Cex> cexes = new ArrayList<>();

            for(CexOrder order:cexOrders) {
                Cex cex = cexService.findById(order.getId());
                if (cex != null)
                    cexes.add(cex);
            }
            System.out.println(cexes.size());
            return new Gson().toJson(cexes);

        }catch (Exception ex){

        }
        return "";
    }





}
