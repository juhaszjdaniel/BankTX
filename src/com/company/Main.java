package com.company;

import org.omg.Messaging.SyncScopeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Account> accounts = createExampleList();
        List<Transaction> transactions = new ArrayList<>();
        int counter = 1;
        getTransactionsFromInput();


    }

    private static void getTransactionsFromInput() {
        while (true) {
            Transaction transaction = new Transaction();

            Scanner input = new Scanner(System.in);  // Create a Scanner object

            System.out.print("Account number (xxxxxxxx-xxxxxxxx): ");
            transaction.setAccountNumber(input.nextLine());

            try {
                System.out.print("Currency: ");
                transaction.setCurrency(Currency.getInstance(input.nextLine().toUpperCase()));


                System.out.print("Amount: ");
                transaction.setAmount(input.nextDouble());

                System.out.print("Exchange Rate: ");
                transaction.setExchangeRate(input.nextDouble());

            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Not valid currency.");
                continue;
            } catch (InputMismatchException e){
                System.out.println("wrong type of input");
                continue;
            }

            System.out.println("Transaction: " + transaction.toString());


            System.out.println("Want to quit: yes/no");
            if ("yes".equalsIgnoreCase(input.next())) {
                break;
            }

        }
    }

    private static List<Account> createExampleList() {
        Account account1 = new Account("11111111-22222222", "HUF", 150000);
        Account account2 = new Account("22222222-33333333", "USD", 1230);

        return Arrays.asList(account1, account2);
    }
}
