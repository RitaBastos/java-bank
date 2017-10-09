package org.academiadecodigo.javabank.Controller.operations;

import org.academiadecodigo.javabank.Controller.transaction.AbstractBankOperation;
import org.academiadecodigo.javabank.View.BankApplication;
import org.academiadecodigo.javabank.Utils.Messages;
import org.academiadecodigo.javabank.Model.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceOperation extends AbstractBankOperation {

    DecimalFormat df = new DecimalFormat("#.##");


    public BalanceOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {

        System.out.println("\n" + customer.getName() + Messages.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));

    }
}
