package com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic;

import com.kazhamiakina.model.DAO.DAOAbstractJDBC;
import com.kazhamiakina.model.DAO.Exception.DAOException;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByVideo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by alisa on 14.01.2017.
 */
public class CharacteristicVideoController extends DAOAbstractJDBC<CharacteristicByVideo> {


    public CharacteristicVideoController() {
        super(ResourceBundle.getBundle("Query.CharacteristicQuery.ChForVideo"));

    }

    @Override
    protected List<CharacteristicByVideo> parseResultSet(ResultSet rs) throws DAOException {
        ArrayList<CharacteristicByVideo> result = new ArrayList<>();
        try {
            while (rs.next()) {
                CharacteristicByVideo characteristicByVideo = new CharacteristicByVideo();
                characteristicByVideo.setId(rs.getInt("characteristic_id"));
                characteristicByVideo.setScreenSize(rs.getInt("screen_size"));
                characteristicByVideo.setMatrixSize(rs.getInt("matrix_size"));
                characteristicByVideo.setBodyColor(rs.getString("body_color"));
                characteristicByVideo.setBatteryResources(rs.getInt("battery_resources"));
                characteristicByVideo.setZoom(rs.getInt("zoom"));
                characteristicByVideo.setMatrixPoint(rs.getInt("matrix_point"));
                result.add(characteristicByVideo);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CharacteristicByVideo object) throws DAOException {
        try {
            statement.setDouble(1, object.getScreenSize());
            statement.setDouble(2, object.getMatrixSize());
            statement.setString(3, object.getBodyColor());
            statement.setInt(4, object.getBatteryResources());
            statement.setInt(5, object.getZoom());
            statement.setDouble(6, object.getMatrixPoint());
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CharacteristicByVideo object) throws DAOException {
        try {
            statement.setDouble(1, object.getScreenSize());
            statement.setDouble(2, object.getMatrixSize());
            statement.setString(3, object.getBodyColor());
            statement.setInt(4, object.getBatteryResources());
            statement.setInt(5, object.getZoom());
            statement.setDouble(6, object.getMatrixPoint());
            statement.setInt(7, object.getId());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
