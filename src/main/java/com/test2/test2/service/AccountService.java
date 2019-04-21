package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountService extends CrudRepository<Account, Long> {
    Account findByName(String name);

    Account findOneById(Long id);

    @Query(value = "select * from account where account.type == (?1)", nativeQuery = true)
    List<Account> findByType(Long type);
}
