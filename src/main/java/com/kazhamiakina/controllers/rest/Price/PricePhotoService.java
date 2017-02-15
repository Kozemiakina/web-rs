package com.kazhamiakina.controllers.rest.Price;

import com.kazhamiakina.controllers.soap.HelloWorld;
import com.kazhamiakina.controllers.soap.HelloWorldService;
import com.kazhamiakina.model.entity.Price.Price;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("/prphoto")
public class PricePhotoService {
    private HelloWorldService service;

    public PricePhotoService() throws MalformedURLException {
        service = new HelloWorldService();
    }
    @GET
    @Produces("application/json")
    public Price[] getAllPriceOfPhoto() throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price[] result = hello.getAllPriceOfPhoto();
        return result;
    }
    @POST
    @Produces("application/json")
    public Price createPriceOfPhoto(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price result = hello.createPriceOfPhoto(price);
        return result;
    }
    @DELETE
    @Path("{id}")
    public void deletePriceOfPhoto(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.deletePriceOfPhoto(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void updatePriceOfPhoto(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.updatePriceOfPhoto(price);
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Price getByPKPriceOfPhoto(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price price = hello.getByPKPriceOfPhoto(id);
        return price;
    }
}
