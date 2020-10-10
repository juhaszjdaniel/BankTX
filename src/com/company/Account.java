package com.company;

public class Account {

    private String accountNumber;

    private String currency;

    private double balance;

    public Account(String accountNumber, String currency, double balance) {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
