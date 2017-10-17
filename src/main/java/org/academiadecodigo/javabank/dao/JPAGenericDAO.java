package org.academiadecodigo.javabank.dao;

import org.academiadecodigo.javabank.manager.SessionManager;
import org.academiadecodigo.javabank.model.AbstractModel;
import java.util.List;

public abstract class JPAGenericDAO <T extends AbstractModel> implements DAO<T> {

    private SessionManager sessionManager;
    private Class<T> tClass;

    public JPAGenericDAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    public List<T> findAll(){

        return sessionManager.getCurrentSession().createQuery("from " + tClass.getSimpleName()).getResultList();
    }


    public T findById(Integer id){

        return sessionManager.getCurrentSession().find(tClass, id);

    }

    public T saveOrUpdate(T object){

        return sessionManager.getCurrentSession().merge(object);

    }

    public void delete(T object) {

        sessionManager.getCurrentSession().remove(object);

    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }


}




