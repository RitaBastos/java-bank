package org.academiadecodigo.javabank.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SessionManager {

    private EntityManagerFactory emf;
    private EntityManager em;


    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
}
