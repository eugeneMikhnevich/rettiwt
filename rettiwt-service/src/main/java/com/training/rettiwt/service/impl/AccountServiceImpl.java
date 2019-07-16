package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.AccountDao;
import com.training.rettiwt.model.Account;
import com.training.rettiwt.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(final AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(final Account account) {
        accountDao.save(account);
    }

    @Override
    public Account get(final Long id) {
        return accountDao.get(id);
    }

    @Override
    public void update(final Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(final Long id) {
        accountDao.delete(id);
    }
}
