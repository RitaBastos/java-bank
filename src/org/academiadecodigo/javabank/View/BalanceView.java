package org.academiadecodigo.javabank.View;

import org.academiadecodigo.javabank.Model.Customer;
import org.academiadecodigo.javabank.Model.account.Account;
import org.academiadecodigo.javabank.Utils.Messages;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView implements View{

    private Customer customer;

    @Override
    public void show() {

        //dizer qual o customer através da classe bank
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("\n" + customer.getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));

    }


}
