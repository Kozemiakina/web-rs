package com.kazhamiakina.controllers.rest.product.description;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Description.PhotoController;
import com.kazhamiakina.model.entity.Product.Description.Product;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/photo")
public class ProductPhotoService {
    PhotoController photoController =new PhotoController();
    @GET
    @Produces("application/json")
    public Product[] getAll() throws MalformedURLException {
        return (Product[])photoController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Product getByPK(@PathParam("id") int id) throws MalformedURLException {
        return photoController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        photoController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( Product product) throws MalformedURLException {
        photoController.update(product);
    }
    @POST
    public Product create(Product product) throws MalformedURLException {
       return photoController.create(product);
    }
}
