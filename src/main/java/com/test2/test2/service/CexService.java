package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.Cex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CexService extends CrudRepository<Cex, Long> {
    @Query(value = "select * from cex where cex.name = (?1)", nativeQuery = true)
    Cex findByName(String name);

    Cex findOneById(Long id);
}
