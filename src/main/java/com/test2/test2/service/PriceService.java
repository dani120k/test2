package com.test2.test2.service;

import com.test2.test2.model.Price;
import com.test2.test2.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PriceService extends CrudRepository<Price, Long> {
    @Query(value = "SELECT * " +
            "FROM price " +
            "WHERE start_date <= (?1) AND end_date >= (?1) AND product_id = (?2) " +
            "ORDER BY creation_date " +
            "LIMIT 1", nativeQuery = true)
    Price findPriceForDate(Date date, Long id);
}
