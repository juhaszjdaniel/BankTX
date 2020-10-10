package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Account> accounts = createExampleList();
        while (true) {
            Transaction transaction = getTransactionFromInput();

        }


    }

    private static Transaction getTransactionFromInput() {
        Transaction transaction = new Transaction();

        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Account number (xxxxxxxx-xxxxxxxx): ");
        transaction.setAccountNumber(input.nextLine());

        System.out.print("Currency: ");
        transaction.setCurrency(input.nextLine());

        System.out.print("Amount: ");
        transaction.setAmount(input.nextDouble());

        System.out.print("Exchange Rate: ");
        transaction.setExchangeRate(input.nextDouble());

        System.out.println("Transaction: " + transaction.toString());
        System.out.println("Want to quit");

        return transaction;
    }

    private static List<Account> createExampleList() {
        Account account1 = new Account("11111111-22222222", "HUF", 150000);
        Account account2 = new Account("22222222-33333333", "USD", 1230);

        return Arrays.asList(account1, account2);
    }
}
