package com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic;

import com.kazhamiakina.model.DAO.DAOAbstractJDBC;
import com.kazhamiakina.model.DAO.Exception.DAOException;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByPhoto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 10.01.2017.
 */
public class CharacteristicPhotoController extends DAOAbstractJDBC<CharacteristicByPhoto> {


    public CharacteristicPhotoController() {
        super(ResourceBundle.getBundle("Query.CharacteristicQuery.ChForPhoto"));

    }
    @Override
    protected List<CharacteristicByPhoto> parseResultSet(ResultSet rs) throws DAOException {
        ArrayList<CharacteristicByPhoto> result = new ArrayList<>();
        try {
            while (rs.next()){
                CharacteristicByPhoto characteristicByPhoto= new CharacteristicByPhoto();
                characteristicByPhoto.setId(rs.getInt("characteristic_id"));
                characteristicByPhoto.setPixels(rs.getInt("pixels"));
                characteristicByPhoto.setBodyColor(rs.getString("body_color"));
                characteristicByPhoto.setVideo(rs.getBoolean("video"));
                characteristicByPhoto.setBatteryResources(rs.getInt("battery_resurs"));
                characteristicByPhoto.setTypeOfCamera(rs.getString("type_of_camera"));
                result.add(characteristicByPhoto);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CharacteristicByPhoto object) throws DAOException {
        try {
            statement.setInt(1,object.getPixels());
            statement.setString(2,object.getBodyColor());
            statement.setBoolean(3,object.isVideo());
            statement.setString(4,object.getTypeOfCamera());
            statement.setInt(5,object.getBatteryResources());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CharacteristicByPhoto object) throws DAOException {
        try {
            statement.setInt(6,object.getId());
            statement.setInt(1,object.getPixels());
            statement.setString(2,object.getBodyColor());
            statement.setBoolean(3,object.isVideo());
            statement.setString(4,object.getTypeOfCamera());
            statement.setInt(5,object.getBatteryResources());
        }
        catch (SQLException e){
            throw new DAOException(e);
        }

    }

}
