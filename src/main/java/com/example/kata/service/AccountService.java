package com.example.kata.service;

import com.example.kata.model.Account;
import com.example.kata.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private final AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account createAccount(Account account){
        accountRepo.save(account);
        return account;
    }

//    public Account withdrawMoneyFromAccount(Long id,Double amount){
//        Account account = accountRepo.findById(id);
//        if (amount <= account.getAmount()){
//            account.setAmount(account.getAmount() - amount);
//            account.setModifiedDate(new Date().toInstant());
//        }
//            accountRepo.save(account);
//        return account;
//    }

    public Account withdrawMoneyFromAccount(Account body){
        Account account = accountRepo.findById(body.getId());
        if (body.getAmount() <= account.getAmount()){
            account.setAmount(account.getAmount() - body.getAmount());
            account.setModifiedDate(new Date().toInstant());
        }
        accountRepo.save(account);
        return account;
    }
}
