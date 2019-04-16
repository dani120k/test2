package com.test2.test2.service;

import com.test2.test2.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderService extends CrudRepository<Order, Long> {
}
