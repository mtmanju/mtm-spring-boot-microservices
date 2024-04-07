package com.mtm.examples.accounts.service.impl;

import com.mtm.examples.accounts.domain.Account;
import com.mtm.examples.accounts.service.AccountService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().accountId(1).customerId(1).number("111111").build());
        accounts.add(Account.builder().accountId(2).customerId(2).number("222222").build());
        accounts.add(Account.builder().accountId(3).customerId(3).number("333333").build());
        accounts.add(Account.builder().accountId(4).customerId(4).number("444444").build());
        accounts.add(Account.builder().accountId(5).customerId(1).number("555555").build());
        accounts.add(Account.builder().accountId(6).customerId(2).number("666666").build());
        accounts.add(Account.builder().accountId(7).customerId(2).number("777777").build());
        return accounts;
    }

    @Override
    public Account findByAccountNumber(String accNumber) {
        Optional<Account> account = getAccounts().stream().filter(acc -> accNumber.equals(acc.getNumber())).findFirst();
        return account.isPresent() ? account.get() : null;
    }

    @Override
    public List<Account> findByCustomerId(Integer customerId) {
        return getAccounts().stream().filter(account -> account.getCustomerId().intValue() == customerId.intValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> findAllAccounts() {
        return getAccounts();
    }

}
