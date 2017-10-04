package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {


        CustomerTest customerTest = new CustomerTest();
        BankTest bankTest = new BankTest();
        CheckingAccountTest checkingTest = new CheckingAccountTest();
        SavingsAccountTest savingsTest = new SavingsAccountTest();


        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));
        System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));
        System.out.println("CheckingAccount: " + (checkingTest.test() ? "OK" : "FAIL"));
        System.out.println("SavingsAccount: " + (savingsTest.test() ? "OK" : "FAIL"));


    }


}
