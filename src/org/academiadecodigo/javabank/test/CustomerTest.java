package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.domain.*;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.domain.account.AccountType;
=======
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

public class CustomerTest {

    public boolean test() {

        AccountManager accountManager = new AccountManager();
        Customer customer = new Customer(1, "Rui");
<<<<<<< HEAD
        customer.setAccountManager(accountManager);
=======
>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d

        // customer should not contain any accounts
        if (customer.getAccountIds().size() != 0) {
            return false;
        }

        // should be able to open accounts
<<<<<<< HEAD
        int ac = customer.openAccount(AccountType.CHECKING);
        int as = customer.openAccount(AccountType.SAVINGS);

        if (customer.getAccountIds().size() != 2) {
            return false;
        }

        // customer should be able to get the balance of each individual account
        accountManager.deposit(ac, 100);
        accountManager.deposit(as, SavingsAccount.MIN_BALANCE + 100);
        if (customer.getBalance(ac) != 100 || customer.getBalance(as) != SavingsAccount.MIN_BALANCE + 100) {
            return false;
        }

=======
        Account ac = accountManager.openAccount(AccountType.CHECKING);
        Account as = accountManager.openAccount(AccountType.SAVINGS);
        customer.addAccount(ac);
        customer.addAccount(as);

        if (customer.getAccountIds().size() != 2) {
            return false;
        }

        // customer should be able to get the balance of each individual account
        accountManager.deposit(ac.getId(), 100);
        accountManager.deposit(as.getId(), SavingsAccount.MIN_BALANCE + 100);
        if (customer.getBalance(ac.getId()) != 100 || customer.getBalance(as.getId()) != SavingsAccount.MIN_BALANCE + 100) {
            return false;
        }

>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d
        // customer should be able to get the combined balance of all its accounts
        if (customer.getBalance() != 200 + SavingsAccount.MIN_BALANCE) {
            return false;
        }

        return true;
    }

}
