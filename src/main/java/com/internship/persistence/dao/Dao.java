package com.internship.persistence.dao;

import java.io.Serializable;
import java.util.Collection;

public interface Dao <T extends Serializable> {
    void save(T entity);
    Collection<T> getAll();
}
