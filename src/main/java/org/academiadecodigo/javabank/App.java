package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {

            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            ApplicationContext context = new ClassPathXmlApplicationContext(
                    new String[] {"META-INF/persistence/persistencecs.xml"}
            );

            LoginController h = context.getBean("loginController", LoginController.class);

            h.init();

            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
