package com.example.kata.controller;

import com.example.kata.DTO.WithdrawDTO;
import com.example.kata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.kata.model.Account;


@RestController
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

//    @PutMapping("/withdrawAccount")
//    public Account withdrawAccount(@RequestBody WithdrawDTO withdrawAmount){
//        return accountService.withdrawMoneyFromAccount(withdrawAmount.id, withdrawAmount.amount);
//    }

    //Pk j'ai le droit de mettre que le id et le amount dans postman ???
    @PutMapping("/withdrawAccount")
    public Account withdrawAccount(@RequestBody Account account){
        return accountService.withdrawMoneyFromAccount(account);
    }
}
