package com.company.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Account {

    private String accountNumber;

    private Currency currency;

    private BigDecimal balance;

    public Account(String accountNumber, Currency currency, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " +
                "accountNumber='" + accountNumber + '\'' +
                ", currency=" + currency +
                ", balance=" + balance;
    }
}
