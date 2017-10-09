package org.academiadecodigo.javabank.View;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.Controller.LoginController;
import org.academiadecodigo.javabank.Model.Bank;
import org.academiadecodigo.javabank.Utils.Messages;

public class LoginView implements View{

    private Prompt prompt;

    private Bank bank;
    private LoginController loginController;

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }



    @Override
    public void show() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);


        loginController.setCustomer(prompt.getUserInput(scanner));

    }
}
