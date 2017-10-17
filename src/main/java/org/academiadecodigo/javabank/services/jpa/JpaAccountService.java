package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.dao.AccountDAO;
import org.academiadecodigo.javabank.manager.SessionManager;
import org.academiadecodigo.javabank.manager.TransactionManager;
import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class JpaAccountService extends AbstractJpaService<Account> implements AccountService {


    private AccountDAO accountDAO;

    private TransactionManager transactionManager;


    public JpaAccountService(EntityManagerFactory emf) {
        super(emf, Account.class);
    }

    @Override
    public void deposit(Integer id, double amount) {


        try{

            transactionManager.beginWrite();

            Account account = accountDAO.findById(id);
            if (account == null) {
                transactionManager.rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.credit(amount);
            accountDAO.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }
    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {

            transactionManager.beginWrite();

            Account account = accountDAO.findById(id);

            if (account == null) {
                 transactionManager.rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);
            accountDAO.saveOrUpdate(account);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {


        try {

            transactionManager.beginWrite();

            Account srcAccount = accountDAO.findById(srcId);
            Account dstAccount = accountDAO.findById(dstId);

            if (srcAccount == null || dstAccount == null) {
                transactionManager.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            // make sure transaction can be performed
            if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
                srcAccount.debit(amount);
                dstAccount.credit(amount);
            }

            accountDAO.saveOrUpdate(srcAccount);
            accountDAO.saveOrUpdate(dstAccount);

            transactionManager.commit();

        } catch (RollbackException ex) {

            transactionManager.rollback();

        }
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }



}
