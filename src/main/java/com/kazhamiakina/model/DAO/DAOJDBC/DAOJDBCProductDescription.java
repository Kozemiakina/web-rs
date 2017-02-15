package com.kazhamiakina.model.DAO.DAOJDBC;

import com.kazhamiakina.model.DAO.DAOAbstractJDBC;
import com.kazhamiakina.model.DAO.Exception.DAOException;
import com.kazhamiakina.model.entity.Product.Description.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 23.01.2017.
 */
public class DAOJDBCProductDescription extends DAOAbstractJDBC <Product> {


    public DAOJDBCProductDescription(ResourceBundle bundle) {
        super(bundle);
    }

    @Override
    protected List<Product> parseResultSet(ResultSet rs) throws DAOException {
        ArrayList<Product> result = new ArrayList<>();
        try {
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setModel(rs.getString("model"));
                product.setCharacteristic(rs.getInt("characteristics"));
                product.setDescription(rs.getString("description"));
                product.setType(rs.getString("type"));
                result.add(product);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Product object) throws DAOException {
        try {
            statement.setString(1,object.getName());
            statement.setString(2,object.getModel());
            statement.setInt(3,object.getCharacteristic());
            statement.setString(4,object.getDescription());
            statement.setString(5,object.getType());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Product object) throws DAOException {
        try {
            statement.setString(1,object.getName());
            statement.setString(2,object.getModel());
            statement.setInt(3,object.getCharacteristic());
            statement.setString(4,object.getDescription());
            statement.setString(5,object.getType());
            statement.setInt(6,object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
