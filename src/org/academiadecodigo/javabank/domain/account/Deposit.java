package org.academiadecodigo.javabank.domain.account;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.Application;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.managers.AccountManager;


public class Deposit implements Application{


    @Override
    public void execute(Customer c1) {

        AccountManager ac1 = new AccountManager();

        c1.setAccountManager(ac1);
        c1.openAccount(AccountType.CHECKING);

        IntegerInputScanner intScanner = new IntegerInputScanner();
        Prompt prompt = new Prompt(System.in, System.out);


        System.out.println("Qual a conta onde pretende depositar?");
        int accountId = prompt.getUserInput(intScanner);

        System.out.println("Qual a quantia?");
        int amount = prompt.getUserInput(intScanner);

        c1.getAccountManager().deposit(accountId, amount);
        System.out.println(c1.getBalance());


        Deposit deposit = new Deposit();

        deposit.execute(c1);











    }
}
