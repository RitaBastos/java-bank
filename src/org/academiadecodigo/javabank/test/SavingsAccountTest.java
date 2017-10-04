package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Account;
import org.academiadecodigo.javabank.domain.SavingsAccount;

public class SavingsAccountTest {

    public boolean test() {

        Account account = new SavingsAccount(1);


        account.credit(200);
        account.debit(20);
        if (account.getBalance() != 180) {
            return  false;
        }

        Account account2 = new SavingsAccount(1);

        account2.credit(200);
        account2.debit(110);

        if(account2.getBalance() !=200 ){
            return false;
        }

        return true;



    }
}
