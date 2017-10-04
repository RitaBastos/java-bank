package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.*;

public class CustomerTest {

    public boolean test() {

        Customer customer = new Customer();

        // customer should start with zero balance
        if (customer.getBalance() != 0) {
            return false;
        }

        Account a1 = new SavingsAccount(1);
        Account a2 = new CheckingAccount(2);
        a1.credit(120);
        a2.credit(100);

        // customer balance should equal sum of all accounts balance
        customer.addAccount(a1);
        customer.addAccount(a2);
        if (customer.getBalance() != 220) {
            return false;
        }



        // customer must be able to perform transfers between accounts
        customer.transfer(a2.getId(), a1.getId(), 20);
        if (a2.getBalance() != 80 || a1.getBalance() != 140) {
            return false;
        }

        customer.transfer(a1.getId(), a2.getId(), 30);
        if (a1.getBalance() != 120 || a2.getBalance() != 100){
            return false;
        }


        return true;
    }
}
