package com.kazhamiakina.controllers.rest.product.characteristic;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic.CharacteristicPhotoController;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByPhoto;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/chrphoto")
public class ChrByPhotoService {
    CharacteristicPhotoController characteristicPhotoController =new CharacteristicPhotoController();
    @GET
    @Produces("application/json")
    public CharacteristicByPhoto[] getAll() throws MalformedURLException {
        return (CharacteristicByPhoto[])characteristicPhotoController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public CharacteristicByPhoto getByPK(@PathParam("id") int id) throws MalformedURLException {
        return characteristicPhotoController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        characteristicPhotoController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( CharacteristicByPhoto characteristicByPhoto) throws MalformedURLException {
        characteristicPhotoController.update(characteristicByPhoto);
    }
    @POST
    public CharacteristicByPhoto create(CharacteristicByPhoto characteristicByPhoto) throws MalformedURLException {
       return characteristicPhotoController.create(characteristicByPhoto);
    }
}
