package org.academiadecodigo.javabank.Controller;


import org.academiadecodigo.javabank.Model.Bank;
import org.academiadecodigo.javabank.View.View;

public class LoginController {


    private View view;
    private Bank bank;
    private MenuController nextController;

    private int acessingCustomer;


    public void setAcessingCustomer(int acessingCustomer) {
        this.acessingCustomer = acessingCustomer;
    }



    public void start(){
        view.show();
    }

    public void setCustomer(int customerId) {
        bank.setAcessingCustomer(customerId);
        nextController.start();


    }

    public void setNextController(MenuController nextController) {
        this.nextController = nextController;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setView(View view) {
        this.view = view;
    }
}
