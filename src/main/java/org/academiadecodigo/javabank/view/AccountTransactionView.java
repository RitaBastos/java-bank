package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controller.transaction.AccountTransactionController;

public class AccountTransactionView extends AbstractView {

    private AccountTransactionController transactionController;

    @Override
    public void show() {

        if (transactionController.getAccountIds().size() == 0) {
            showNoAccounts();
            return;
        }

        showAccounts();

        transactionController.submitTransaction(scanAccount(), scanAmount());
    }

    public void showNoAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_NOACCOUNT_ERROR);
    }

    public void showAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTS_MESSAGE + buildAccountList());
    }

    private String buildAccountList() {

        StringBuilder builder = new StringBuilder();

        for (Integer id : transactionController.getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    private int scanAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(transactionController.getAccountIds());
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTID_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_ACCOUNT_ERROR);
        return prompt.getUserInput(scanner);

    }

    private double scanAmount() {

        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_AMOUNT_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_AMOUNT_ERROR);
        return prompt.getUserInput(scanner);
    }

    public void setTransactionController(AccountTransactionController transactionController) {
        this.transactionController = transactionController;
    }
}
