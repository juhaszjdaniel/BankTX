package com.company.service;

import com.company.domain.Account;
import com.company.domain.Transaction;
import com.company.exception.WrongAccountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TransactionServiceImpl implements TransactionService {

    Scanner input = new Scanner(System.in);

    @Override
    public void getTransactionsFromInput(List<Account> accounts) {
        List<Transaction> transactions = new ArrayList<>();
        int counter = 1;

        while (true) {
            try {
                Transaction transaction = getTransactionFromInput();

                Account usedAccount = getUsedAccount(accounts, transaction);

                checkAccount(usedAccount);

                transactions.add(transaction);

                changeAccountBalance(transaction, usedAccount);

                if (counter == 10) {
                    printReport(accounts, transactions);
                    counter = 0;
                }
                counter++;

                wantToQuit();

            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Not valid currency.");
            } catch (InputMismatchException e) {
                System.out.println("wrong type of input");
            } catch (WrongAccountException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                break;
            }

        }
    }

    private void checkAccount(Account usedAccount) throws WrongAccountException {
        if (usedAccount == null) {
            throw new WrongAccountException("Warning: wrong account");
        }
    }

    private void wantToQuit() {
        System.out.println("Want to quit: yes/no");
        if ("yes".equalsIgnoreCase(input.next())) {
            System.exit(0);
        }
    }

    private Transaction getTransactionFromInput() {
        Transaction transaction = new Transaction();

        System.out.print("Account number (xxxxxxxx-xxxxxxxx): ");
        transaction.setAccountNumber(input.nextLine());

        System.out.print("Currency: ");
        transaction.setCurrency(Currency.getInstance(input.nextLine().toUpperCase()));

        System.out.print("Amount: ");
        transaction.setAmount(input.nextBigDecimal());

        System.out.print("Exchange Rate: ");
        transaction.setExchangeRate(input.nextDouble());

        return transaction;
    }

    private static void printReport(List<Account> accounts, List<Transaction> transactions) {
        accounts.forEach(account -> {
            System.out.println(account);
            transactions.stream()
                    .filter(transaction1 -> transaction1.getAccountNumber().equalsIgnoreCase(account.getAccountNumber()))
                    .forEach(System.out::println);
        });
    }

    private static void changeAccountBalance(Transaction transaction, Account usedAccount) {
        if (usedAccount.getCurrency() == transaction.getCurrency()) {
            usedAccount.setBalance(usedAccount.getBalance().add(transaction.getAmount()));
        } else {
            BigDecimal amountRightCurrency = transaction.getAmount().multiply(BigDecimal.valueOf(transaction.getExchangeRate()));
            usedAccount.setBalance(usedAccount.getBalance().subtract(amountRightCurrency));
        }
    }

    private static Account getUsedAccount(List<Account> accounts, Transaction transaction) {
        return accounts.stream().filter(account -> account.getAccountNumber().equalsIgnoreCase(transaction.getAccountNumber())).findFirst().orElse(null);
    }
}
