package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Account;
import com.training.rettiwt.service.api.AccountService;
import com.training.rettiwt.web.converter.AccountDtoConverter;
import com.training.rettiwt.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private AccountService accountService;
    private AccountDtoConverter accountDtoConverter;

    @Autowired
    public AccountController(final AccountService accountService,
                             final AccountDtoConverter accountDtoConverter) {
        this.accountService = accountService;
        this.accountDtoConverter = accountDtoConverter;
    }

    @GetMapping("{id}")
    public AccountDto findById(@PathVariable(name = "id") Long id) {
        Account account = accountService.findById(id);
        return accountDtoConverter.convertToDto(account);
    }

    @GetMapping
    public List<AccountDto> findAll() {
        return accountService.findAll().stream()
                .map(accountDtoConverter::convertToDto)
                .collect(toList());
    }

    @PostMapping
    public void save(@RequestBody AccountDto accountDto) {
        Account account = accountDtoConverter.convertFromDto(accountDto);
        accountService.save(account);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody AccountDto accountDto) {
        Account account = accountDtoConverter.convertFromDto(accountDto);
        accountService.update(id, account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }
}
