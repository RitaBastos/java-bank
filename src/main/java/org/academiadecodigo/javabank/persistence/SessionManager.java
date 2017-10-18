package org.academiadecodigo.javabank.persistence;

import javax.persistence.PersistenceUnit;

@PersistenceUnit

public interface SessionManager<T> {

    void startSession();

    void stopSession();

    T getCurrentSession();

}
