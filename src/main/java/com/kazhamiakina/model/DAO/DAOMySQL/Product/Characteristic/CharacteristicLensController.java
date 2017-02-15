package com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic;

import com.kazhamiakina.model.DAO.DAOAbstractJDBC;
import com.kazhamiakina.model.DAO.Exception.DAOException;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByLens;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 14.01.2017.
 */
public class CharacteristicLensController extends DAOAbstractJDBC<CharacteristicByLens> {
    public CharacteristicLensController() {
        super(ResourceBundle.getBundle("Query.CharacteristicQuery.ChForLens"));
    }

    @Override
    protected List<CharacteristicByLens> parseResultSet(ResultSet rs) throws DAOException {
        ArrayList<CharacteristicByLens> result = new ArrayList<>();
        try {
            while (rs.next()){
                CharacteristicByLens characteristicByLens = new CharacteristicByLens();
                characteristicByLens.setId(rs.getInt("characteristic_id"));
                characteristicByLens.setMount(rs.getString("mount"));
                characteristicByLens.setFocalLength(rs.getInt("focal_length"));
                characteristicByLens.setRatio(rs.getInt("ratio"));
                characteristicByLens.setAutoFocus(rs.getBoolean("autofocus"));
                characteristicByLens.setFilter(rs.getInt("filter"));
                result.add(characteristicByLens);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CharacteristicByLens object) throws DAOException {
        try {
            statement.setString(1,object.getMount());
            statement.setInt(2,object.getFocalLength());
            statement.setDouble(3,object.getRatio());
            statement.setBoolean(4,object.isAutoFocus());
            statement.setInt(5,object.getFilter());
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }


    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CharacteristicByLens object) throws DAOException {
        try {
            statement.setString(1,object.getMount());
            statement.setInt(2,object.getFocalLength());
            statement.setDouble(3,object.getRatio());
            statement.setBoolean(4,object.isAutoFocus());
            statement.setInt(5,object.getFilter());
            statement.setInt(6,object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }


}
