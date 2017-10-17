package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.dao.CustomerDAO;
import org.academiadecodigo.javabank.manager.SessionManager;
import org.academiadecodigo.javabank.manager.TransactionManager;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerService extends AbstractJpaService<Customer> implements CustomerService {

    public CustomerDAO customerDAO;

    private TransactionManager transactionManager;

    public JpaCustomerService(EntityManagerFactory emf) {
        super(emf, Customer.class);
    }

    @Override
    public double getBalance(Integer id) {

        try {

            transactionManager.beginRead();

            Customer customer = customerDAO.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }


            List<Account> accounts = customer.getAccounts();

            double balance = 0;
            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } catch(TransactionException ex){
            transactionManager.rollback();
        }

        return -1;

    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        try {

            transactionManager.beginRead();

            Customer customer = customerDAO.findById(id);

            if (customer == null) {

                throw new IllegalArgumentException("Customer does not exists");
            }

            Set<Integer> accountIds = new HashSet<>();
            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;

        } catch(TransactionException ex){
            transactionManager.rollback();
        }

        return null;

    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


}
