package com.kazhamiakina.model.DAO.DAOMySQL.Users;

import com.kazhamiakina.model.DAO.DAOJDBC.DAOJDBCUser;

import java.util.ResourceBundle;

/**
 * Created by alisa on 23.01.2017.
 */
public class UserController extends DAOJDBCUser {

    public UserController(){

        super(ResourceBundle.getBundle("Query.ProductQuery.User"));
    }
}
