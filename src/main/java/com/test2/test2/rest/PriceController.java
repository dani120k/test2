package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Price;
import com.test2.test2.model.Product;
import com.test2.test2.service.PriceServiceImpl;
import com.test2.test2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/price")
public class PriceController {
    @Autowired
    private PriceServiceImpl priceService;

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String createPrice(@RequestBody Price price, @RequestParam String productName){
        Product product = productService.findByName(productName);
        Date date = new Date();
        price.setCreation_date(date);
        price.setProduct_id(product.getId());
        Price addedPrice = priceService.add(price);
        if (addedPrice !=null) {
            product.getPriceList().add(addedPrice);
            productService.update(product);
            return new Gson().toJson(addedPrice);
        }
        else
            return "Some error when create this price";
    }
}
