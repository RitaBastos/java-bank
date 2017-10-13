package org.academiadecodigo.javabank.model.account;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "accountType")

public abstract class Account extends AbstractModel  {

    private double balance = 0;

    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    @ManyToOne
        private Customer customer;


    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType(){
        return null;
    }

    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    public boolean canCredit(double amount) {
        return amount > 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}