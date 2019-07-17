package com.training.rettiwt.web.converter;

import com.training.rettiwt.model.Account;
import com.training.rettiwt.web.dto.AccountDto;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setCreatedAt(account.getCreatedAt());
        accountDto.setUpdatedAt(account.getUpdatedAt());
        accountDto.setEmail(account.getEmail());
        accountDto.setPassword(account.getPassword());
        accountDto.setPhone(account.getPhone());
        accountDto.setDeleted(account.getDeleted());
        return accountDto;
    }

    public Account convertFromDto(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setCreatedAt(accountDto.getCreatedAt());
        account.setUpdatedAt(accountDto.getUpdatedAt());
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        account.setPhone(accountDto.getPhone());
        account.setDeleted(accountDto.getDeleted());
        return account;
    }
}
