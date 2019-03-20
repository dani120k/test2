package com.test2.test2.service;

import com.test2.test2.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceService extends CrudRepository<Price, Long> {
}
