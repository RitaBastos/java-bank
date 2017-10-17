package org.academiadecodigo.javabank.services.mock;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.dao.DAO;

import java.util.*;

public class AbstractMockService<T extends AbstractModel> implements DAO<T> {

    protected Map<Integer, T> modelMap = new HashMap<>();

    @Override
    public List<T> findAll() {
        return new ArrayList<>(modelMap.values());
    }

    @Override
    public T findById(Integer id) {
        return modelMap.get(id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {

        if (modelObject.getId() == null) {
            modelObject.setId(getNextId());
        }

        modelMap.put(modelObject.getId(), modelObject);

        return modelObject;

    }

    @Override
    public void delete(T object) {
        modelMap.remove(object);
    }

    private Integer getNextId() {
        return modelMap.isEmpty() ? 1 : Collections.max(modelMap.keySet()) + 1;
    }
}