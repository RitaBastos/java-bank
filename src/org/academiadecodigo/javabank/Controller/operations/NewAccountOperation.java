package org.academiadecodigo.javabank.Controller.operations;

import org.academiadecodigo.javabank.Controller.transaction.AbstractBankOperation;
import org.academiadecodigo.javabank.View.BankApplication;
import org.academiadecodigo.javabank.Utils.Messages;
import org.academiadecodigo.javabank.Model.account.AccountType;

public class NewAccountOperation extends AbstractBankOperation {

    public NewAccountOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {

        int accountId = customer.openAccount(AccountType.CHECKING);

        System.out.println("\n" + Messages.CREATED_ACCOUNT + customer.getName() + " : " + accountId);

    }
}
