package com.studentmanagement.util;

import java.sql.Connection;
import java.util.List;

public abstract class DataAccessObject<T> {
    protected Connection connection;

    public DataAccessObject(Connection connection) {
        super();
        this.connection = connection;
    }

    public abstract T findById(long id);

    public abstract List<T> findAll();

    public abstract T update(T dao);

    public abstract T create(T dao);

    public abstract void delete(long id);

}