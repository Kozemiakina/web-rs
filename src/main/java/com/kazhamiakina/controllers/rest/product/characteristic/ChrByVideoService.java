package com.kazhamiakina.controllers.rest.product.characteristic;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic.CharacteristicVideoController;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByVideo;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/chrvideo")
public class ChrByVideoService {
    CharacteristicVideoController characteristicVideoController =new CharacteristicVideoController();
    @GET
    @Produces("application/json")
    public CharacteristicByVideo[] getAll() throws MalformedURLException {
        return (CharacteristicByVideo[])characteristicVideoController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public CharacteristicByVideo getByPK(@PathParam("id") int id) throws MalformedURLException {
        return characteristicVideoController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        characteristicVideoController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( CharacteristicByVideo characteristicByVideo) throws MalformedURLException {
        characteristicVideoController.update(characteristicByVideo);
    }
    @POST
    public CharacteristicByVideo create(CharacteristicByVideo characteristicByVideo) throws MalformedURLException {
       return characteristicVideoController.create(characteristicByVideo);
    }
}
