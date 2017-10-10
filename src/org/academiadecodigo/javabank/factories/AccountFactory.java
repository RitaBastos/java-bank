package org.academiadecodigo.javabank.factories;

<<<<<<< HEAD
import org.academiadecodigo.javabank.domain.account.*;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
=======
import org.academiadecodigo.javabank.model.account.*;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

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
