package org.academiadecodigo.javabank.dao;

import org.academiadecodigo.javabank.model.AbstractModel;

import java.util.List;

public interface DAO<T extends AbstractModel> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(T object);

}