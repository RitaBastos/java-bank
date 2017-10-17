package org.academiadecodigo.javabank.dao;

import org.academiadecodigo.javabank.model.account.Account;

public class JPAAccountDAO extends JPAGenericDAO<Account> implements AccountDAO{


    public JPAAccountDAO(Class aClass) {
        super(aClass);
    }
}
