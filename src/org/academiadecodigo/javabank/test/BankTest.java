package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.domain.*;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.domain.account.AccountType;
=======
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

public class BankTest {

    public boolean test() {

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        bank.addCustomer(c1);
        bank.addCustomer(c2);

<<<<<<< HEAD
        int a1 = c1.openAccount(AccountType.CHECKING);
        int a2 = c2.openAccount(AccountType.CHECKING);

        accountManager.deposit(a1, 100);
        accountManager.deposit(a2, 100);
=======
        Account a1 = accountManager.openAccount(AccountType.CHECKING);
        Account a2 = accountManager.openAccount(AccountType.CHECKING);

        c1.addAccount(a1);
        c2.addAccount(a2);

        accountManager.deposit(a1.getId(), 100);
        accountManager.deposit(a2.getId(), 100);
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

        // bank balance should equal sum of all customers balance
        if (bank.getBalance() != 200) {
            return false;
        }

        return true;
    }
}
