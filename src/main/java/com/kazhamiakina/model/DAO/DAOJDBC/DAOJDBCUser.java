package com.kazhamiakina.model.DAO.DAOJDBC;

import com.kazhamiakina.model.DAO.DAOAbstractJDBC;
import com.kazhamiakina.model.DAO.Exception.DAOException;
import com.kazhamiakina.model.entity.Users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 23.01.2017.
 */
public class DAOJDBCUser extends DAOAbstractJDBC<User> {
    public DAOJDBCUser(ResourceBundle resourceBundle) {
        super(resourceBundle);
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws DAOException {
        ArrayList<User> result = new ArrayList<>();
        try {
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("price_id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setRole(rs.getString("role"));
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws DAOException {
        try {
            statement.setString(1,object.getName());
            statement.setString(2,object.getLastName());
            statement.setString(3,object.getRole());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws DAOException {
        try {
            statement.setString(1,object.getName());
            statement.setString(2,object.getLastName());
            statement.setString(3,object.getRole());
            statement.setInt(4,object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}