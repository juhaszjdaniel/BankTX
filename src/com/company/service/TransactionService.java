package com.company.service;

import com.company.domain.Account;

import java.util.List;

public interface TransactionService {

    void goThroughTransactions(List<Account> accounts);
}
