package org.academiadecodigo.javabank.Utils;

import org.academiadecodigo.javabank.Model.account.Account;
import org.academiadecodigo.javabank.Model.account.AccountType;
import org.academiadecodigo.javabank.Model.account.SavingsAccount;
import org.academiadecodigo.javabank.Model.account.CheckingAccount;

public class AccountFactory {

    private int nextAccountId = 1;

    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount(getNextId());
                break;
            case SAVINGS:
                newAccount = new SavingsAccount(getNextId());
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }

    private int getNextId() {
        return nextAccountId++;
    }
}
