package org.academiadecodigo.javabank;

<<<<<<< HEAD
import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        BankApplication bankApplication = new BankApplication(bank);
        bankApplication.start();
    }
=======
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Bank;

public class App {

    private Bank bank;

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        bank = bootstrap.generateTestData();

        LoginController loginController = bootstrap.wireObjects(bank);

        // start application
        loginController.init();

    }

>>>>>>> 7f35b9cba6d94285a095bca5c3e47eae165d0f9d
}
