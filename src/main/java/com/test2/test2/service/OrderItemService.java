package com.test2.test2.service;

import com.test2.test2.model.Order;
import com.test2.test2.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemService extends CrudRepository<OrderItem, Long> {
}
