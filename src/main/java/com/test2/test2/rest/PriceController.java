package com.test2.test2.rest;

import com.google.gson.Gson;
import com.test2.test2.model.Price;
import com.test2.test2.service.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/price")
public class PriceController {
    @Autowired
    private PriceServiceImpl priceService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String createPrice(@RequestBody Price price){
        Price addedPrice = priceService.add(price);
        if (addedPrice !=null)
            return new Gson().toJson(addedPrice);
        else
            return "Some error when create this price";
    }
}
