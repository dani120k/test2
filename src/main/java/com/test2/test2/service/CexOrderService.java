package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.CexOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CexOrderService extends CrudRepository<CexOrder, Long> {
    CexOrder findByName(String name);

    List<CexOrder> findAllByProductid(Long id);
}
