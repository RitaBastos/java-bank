package org.academiadecodigo.javabank.domain;

public class CheckingAccount extends Account{

    //private double fee;



    public CheckingAccount(int id) {
       super(id);
    }

    //public void deductFee(){
         //setBalance(getBalance()-fee);

    //}


    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}



