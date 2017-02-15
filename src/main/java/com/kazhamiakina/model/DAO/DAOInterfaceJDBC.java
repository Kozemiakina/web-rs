package com.kazhamiakina.model.DAO;

import com.kazhamiakina.model.DAO.Exception.DAOException;

import java.util.List;

/**
 * Created by alisa on 22.01.2017.
 */
public interface DAOInterfaceJDBC<T> {

    public List<T> getAll();
    public void delete(int id);
    public void update(T object);
    public T getByPK(int id);
    public T create(T object)throws DAOException;
}
