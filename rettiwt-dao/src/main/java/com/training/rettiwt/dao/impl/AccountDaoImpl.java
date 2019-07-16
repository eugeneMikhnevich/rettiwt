package com.training.rettiwt.dao.impl;

import com.training.rettiwt.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> {

    public AccountDaoImpl() {
        super(Account.class);
    }
}
