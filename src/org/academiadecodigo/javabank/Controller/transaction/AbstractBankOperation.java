package org.academiadecodigo.javabank.Controller.transaction;

import org.academiadecodigo.javabank.Model.Customer;
import org.academiadecodigo.javabank.Controller.operations.Operation;
import org.academiadecodigo.javabank.View.BankApplication;

public abstract class AbstractBankOperation implements Operation {

    protected BankApplication bankApplication;
    protected Customer customer;

    public AbstractBankOperation(BankApplication bankApplication) {
        this.bankApplication = bankApplication;
        customer = bankApplication.getBank().getCustomer(bankApplication.getAcessingCustomerId());
    }
}
