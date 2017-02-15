package com.kazhamiakina.controllers.rest.product.description;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Description.LensController;
import com.kazhamiakina.model.entity.Product.Description.Product;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/lens")
public class ProductLensService {
    LensController lensController =new LensController();
    @GET
    @Produces("application/json")
    public Product[] getAll() throws MalformedURLException {
        return (Product[])lensController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Product getByPK(@PathParam("id") int id) throws MalformedURLException {
        return lensController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        lensController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( Product product) throws MalformedURLException {
        lensController.update(product);
    }
    @POST
    @Produces("application/json")
    public Product create(Product product) throws MalformedURLException {
        return lensController.create(product);
    }
}
