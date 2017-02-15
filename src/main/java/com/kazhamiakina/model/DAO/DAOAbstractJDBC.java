package com.kazhamiakina.model.DAO;

import com.kazhamiakina.model.DAO.Exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 22.01.2017.
 */
public abstract class DAOAbstractJDBC<T> implements DAOInterfaceJDBC<T> {

    public ResourceBundle resourceBundle;
    ResourceBundle resourceBundleConnection = ResourceBundle.getBundle("Query.Configurate") ;


    public DAOAbstractJDBC(ResourceBundle resourceBundle) {
        this.resourceBundle= resourceBundle;
    }

    public  String getAllQuery(){
        return resourceBundle.getString("select");
    }//method to query to retrieve all records from a table
    public  String getByPK(){
        return resourceBundle.getString("select");
    }//method to query to select records from a table
    public  String CreateQuery(){
        return resourceBundle.getString("create");
    }//method for the request for the creation of records in a table
    public  String DeleteQuery() {
        return resourceBundle.getString("delete");
    }//method for the request for the delete of records from a table
    protected  String UpdateQuery(){
        return resourceBundle.getString("update");
    }// method for requesting update records in table

    protected abstract List<T> parseResultSet(ResultSet rs) throws DAOException;
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DAOException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DAOException;

    public Connection getConnection() throws DAOException, SQLException {
        Connection connection = null;
        ConnectionPool connectionPool=new ConnectionPool(resourceBundleConnection.getString("url"),
                resourceBundleConnection.getString("driver"),
                Integer.parseInt(resourceBundleConnection.getString("max")),
                resourceBundleConnection.getString("user"),
                resourceBundleConnection.getString("password"));
        return connectionPool.retrieve();
    }

    public List<T> getAll(){
        List<T> list = null;
        String sql = getAllQuery();
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            try {
                throw new DAOException(e);
            } catch (DAOException e1) {
                e1.printStackTrace();
            }
        }
        return list;
    }

    public void delete(int id) {
        String sql = DeleteQuery();
        PreparedStatement statement = null ;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setObject(1, id);

            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }
    }

    public void update(T object){
        String sql = UpdateQuery();
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            prepareStatementForUpdate(statement, object); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On update modify more then 1 record: " + count);
            }
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }
    }


    public T getByPK(int id) {
        List<T> list = null;
        String sql = getByPK();
        sql += " WHERE id = ?";

            try {
                PreparedStatement statement = getConnection().prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                list = parseResultSet(rs);
                if (list == null || list.size() == 0) {
                    throw new DAOException("Record with PK = " + id + " not found.");
                }
                if (list.size() > 1) {
                    throw new DAOException("Received more than one record.");
                }
            } catch (DAOException | SQLException e) {
                e.printStackTrace();
            }
        return list.iterator().next();
    }
    public T create(T object) {
        T persistInstance = null;
        // Добавляем запись
        String sql = CreateQuery();
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On persist modify more then 1 record: " + count);
            }
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }


        // Получаем только что вставленную запись
        sql = getByPK() + " WHERE id = last_insert_id();";
        try {
            statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new DAOException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }
        return persistInstance;
    }


}
