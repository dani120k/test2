package com.test2.test2.service;

import com.test2.test2.model.Account;
import com.test2.test2.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface AccountService extends CrudRepository<Account, Long> {
    Account findByName(String name);

    Account findOneById(Long id);
}
