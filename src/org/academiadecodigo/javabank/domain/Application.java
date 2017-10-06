package org.academiadecodigo.javabank.domain;//package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public interface Application {

    void execute(Customer c1);

}

public static void main(String[] args) {


        AccountManager ac1 = new AccountManager();
        Customer c1 = new Customer();


        c1.setAccountManager(ac1);
        c1.openAccount(AccountType.CHECKING);

        // Define some options for the menu
        String[] options = {"Deposit", "Withdraw", "Transfer", "Get Balance"};


        IntegerInputScanner intScanner = new IntegerInputScanner();

        // Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

        // Setup the menu prompt message
        scanner.setMessage("Choose an option: ");



    }

