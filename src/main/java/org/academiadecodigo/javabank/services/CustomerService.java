package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.dao.DAO;
import org.academiadecodigo.javabank.model.Customer;

import java.util.Set;

public interface CustomerService extends DAO<Customer> {

    double getBalance(Integer id);

    Set<Integer> getCustomerAccountIds(Integer id);

}
