package com.company;

import com.company.domain.Account;
import com.company.domain.Transaction;
import com.company.service.TransactionService;
import com.company.service.TransactionServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Account> accounts = createExampleList();
    private static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        TransactionService transactionService = new TransactionServiceImpl();

        getTransactionsFromInput();

    }

    private static void getTransactionsFromInput() {
        int counter = 1;

        while (true) {
            Transaction transaction = new Transaction();

            Scanner input = new Scanner(System.in);  // Create a Scanner object


            try {
                System.out.print("Account number (xxxxxxxx-xxxxxxxx): ");
                transaction.setAccountNumber(input.nextLine());

                System.out.print("Currency: ");
                transaction.setCurrency(Currency.getInstance(input.nextLine().toUpperCase()));

                System.out.print("Amount: ");
                transaction.setAmount(input.nextBigDecimal());

                System.out.print("Exchange Rate: ");
                transaction.setExchangeRate(input.nextDouble());

            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Not valid currency.");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("wrong type of input");
                continue;
            }


            Account usedAccount = getUsedAccount(transaction);

            if (usedAccount == null) {
                System.out.println("Warning: wrong account");
                continue;
            }

            transactions.add(transaction);

            changeAccountBalance(transaction, usedAccount);

            if (counter == 10) {
                printReport();
                counter = 0;
            }
            counter++;

            System.out.println("Want to quit: yes/no");
            if ("yes".equalsIgnoreCase(input.next())) {
                break;
            }

        }
    }

    private static void printReport() {
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

    private static Account getUsedAccount(Transaction transaction) {
        return accounts.stream().filter(account -> account.getAccountNumber().equalsIgnoreCase(transaction.getAccountNumber())).findFirst().orElse(null);
    }

    private static List<Account> createExampleList() {
        Account account1 = new Account("11111111-22222222", Currency.getInstance("HUF"), BigDecimal.valueOf(150000));
        Account account2 = new Account("22222222-33333333", Currency.getInstance("USD"), BigDecimal.valueOf(1230));

        return Arrays.asList(account1, account2);
    }
}
