package com.company.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {
    private String accountNumber;

    private Currency currency;

    private BigDecimal amount;

    private double exchangeRate;

    public Transaction() {
    }

    public Transaction(String accountNumber, Currency currency, BigDecimal amount, double exchangeRate) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.exchangeRate = exchangeRate;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Transaction: accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", exchangeRate=" + exchangeRate;
    }
}
