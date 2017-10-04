package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.CheckingAccount;

public class CheckingAccountTest {

    public boolean test() {

        Account account = new CheckingAccount(1);

        // account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }



        Account account3 = new CheckingAccount(1);

        account3.credit(90);

        // we should be able to take money from account
        account3.debit(40);
        if (account3.getBalance() != 50) {
            return  false;
        }

        return true;





    }

}
