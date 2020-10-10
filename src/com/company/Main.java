package com.company;

import com.company.domain.Account;
import com.company.service.TransactionService;
import com.company.service.TransactionServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class Main {
    private static final List<Account> accounts = createExampleList();

    public static void main(String[] args) {
        TransactionService transactionService = new TransactionServiceImpl();
        transactionService.getTransactionsFromInput(accounts);

    }

    private static List<Account> createExampleList() {
        Account account1 = new Account("11111111-22222222", Currency.getInstance("HUF"), BigDecimal.valueOf(150000));
        Account account2 = new Account("22222222-33333333", Currency.getInstance("USD"), BigDecimal.valueOf(1230));

        return Arrays.asList(account1, account2);
    }
}
