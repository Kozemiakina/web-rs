package com.kazhamiakina.controllers.rest.product.characteristic;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Characteristic.CharacteristicLensController;
import com.kazhamiakina.model.entity.Product.Characteristic.CharacteristicByLens;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/chrlens")
public class ChrByLensService {
    CharacteristicLensController characteristicLensController = new CharacteristicLensController();
    @GET
    @Produces("application/json")
    public CharacteristicByLens[] getAllChrByLens() throws MalformedURLException {
        return (CharacteristicByLens[])characteristicLensController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public CharacteristicByLens getByPKChrByLens(@PathParam("id") int id) throws MalformedURLException {
        return characteristicLensController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void deleteChrByLens(@PathParam("id") int id) throws MalformedURLException {
        characteristicLensController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void updateChrByLens( CharacteristicByLens characteristicByLens) throws MalformedURLException {
        characteristicLensController.update(characteristicByLens);
    }
    @POST
    public CharacteristicByLens createChrByLens(CharacteristicByLens characteristicByLens) throws MalformedURLException {
       return characteristicLensController.create(characteristicByLens);
    }
}
