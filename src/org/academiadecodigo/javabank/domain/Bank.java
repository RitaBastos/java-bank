package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    private AccountManager accountManager;
    private Set<Customer> customers = new HashSet<>();

    //private Option option;

    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    //public void createaccount(){
      //  option.execute("Create account");
    //}

    //public void setOption(Option option) {
      //  this.option = ;
    //}

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setAccountManager(accountManager);
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers) {
            balance += customer.getBalance();
        }

        return balance;
    }

}
