package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Account;
import com.training.rettiwt.service.api.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{id}")
    public Account findById(@PathVariable(name = "id") Long id) {
        log.info("/accounts/{id} was requested");
        return accountService.findById(id);
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Account account) {
        accountService.save(account);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Account account) {
        accountService.update(id, account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }
}
