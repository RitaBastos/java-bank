package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;
=======

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

public class CheckingAccountTest {

    public boolean test() {

        Account account = new CheckingAccount(1);

        // initial balance should be zero
<<<<<<< HEAD
=======
        if (account.getBalance() != 0) {
            return false;
        }

        // should not be possible to credit or debit negative values
        account.credit(-1);
        account.debit(-2);
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d
        if (account.getBalance() != 0) {
            return false;
        }

<<<<<<< HEAD
        // should not be possible to credit or debit negative values
        account.credit(-1);
        account.debit(-2);
        if (account.getBalance() != 0) {
            return false;
        }

        // should be possible to credit account with positive value
        account.credit(10);
        if (account.getBalance() != 10) {
            return false;
        }

=======
        // should be possible to credit account with positive value
        account.credit(10);
        if (account.getBalance() != 10) {
            return false;
        }

>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d
        // should not be possible to debit account if no sufficient funds
        account.debit(11);
        if (account.getBalance() != 10) {
            return false;
        }

        // should be possible to debit account if sufficient funds
        account.debit(8);
        if (account.getBalance() != 2) {
            return false;
        }

        return true;
    }
}
