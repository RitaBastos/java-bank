package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int id) {
        super(id);
    }


    @Override
    public void debit(double amount) {


        if (getBalance() - amount < 100) {

            return;
        }

        super.debit(amount);

    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}






