package com.kazhamiakina.model.DAO.DAOMySQL.Product.Description;

import com.kazhamiakina.model.DAO.DAOJDBC.DAOJDBCProductDescription;

import java.util.ResourceBundle;

/**
 * Created by alisa on 14.01.2017.
 */
public class LensController extends DAOJDBCProductDescription{

    public LensController(){
        super( ResourceBundle.getBundle("Query.ProductQuery.Lens"));

    }
}
