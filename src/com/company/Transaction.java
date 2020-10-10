package com.company;

public class Transaction {
    private String accountNumber;

    private String currency;

    private double amount;

    private double exchangeRate;

    public Transaction() {
    }

    public Transaction(String accountNumber, String currency, double amount, double exchangeRate) {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
