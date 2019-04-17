package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.Cex;
import org.springframework.data.repository.CrudRepository;

public interface CexService extends CrudRepository<Cex, Long> {
    Cex findByName(String name);
}
