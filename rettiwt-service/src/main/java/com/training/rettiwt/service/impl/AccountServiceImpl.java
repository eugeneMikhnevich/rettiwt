package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.AccountDao;
import com.training.rettiwt.model.Account;
import com.training.rettiwt.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(final AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(final Account account) {
        LocalDateTime now = now();
        account.setCreatedAt(now);
        account.setUpdatedAt(now);
        accountDao.save(account);
    }

    @Override
    public Account findById(final Long id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void update(final Long id, final Account account) {
        account.setId(id);
        account.setUpdatedAt(now());
        accountDao.update(account);
    }

    @Override
    public void delete(final Long id) {
        accountDao.delete(id);
    }
}
