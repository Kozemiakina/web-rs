package com.kazhamiakina.controllers.rest.product.description;

import com.kazhamiakina.model.DAO.DAOMySQL.Product.Description.VideoController;
import com.kazhamiakina.model.entity.Product.Description.Product;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/video")
public class ProductVideoService {
    VideoController videoController =new VideoController();
    @GET
    @Produces("application/json")
    public Product[] getAll() throws MalformedURLException {
        return (Product[])videoController.getAll().toArray();
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Product getByPK(@PathParam("id") int id) throws MalformedURLException {
        return videoController.getByPK(id);
    }
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) throws MalformedURLException {
        videoController.delete(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void update( Product product) throws MalformedURLException {
        videoController.update(product);
    }
    @POST
    public Product create(Product product) throws MalformedURLException {
      return   videoController.create(product);
    }
}
