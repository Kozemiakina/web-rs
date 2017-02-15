package com.kazhamiakina.controllers.rest.Price;

import com.kazhamiakina.controllers.soap.HelloWorld;
import com.kazhamiakina.controllers.soap.HelloWorldService;
import com.kazhamiakina.model.entity.Price.Price;

import javax.ws.rs.*;
import java.net.MalformedURLException;

/**
 * Created by alisa on 09.02.2017.
 */
@Path("prvideo")
public class PriceVideoService {
    private HelloWorldService service;

    public PriceVideoService() throws MalformedURLException {
        service = new HelloWorldService();
    }
    @GET
    @Produces("application/json")
    public Price[] getAllPriceOfVideo() throws MalformedURLException {
        HelloWorld hello = service.getHelloWorldImplPort();
        Price[] result = hello.getAllPriceOfVideo();
        return result;
    }

    @POST
    @Produces("application/json")
    public Price createPriceOfVideo(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price result = hello.createPriceOfVideo(price);
        return result;
    }
    @DELETE
    @Path("{id}")
    public void deletePriceOfVideo(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.deletePriceOfVideo(id);
    }
    @PUT
    @Path("{characteristicByLens}")
    public void updatePriceOfVideo(Price price) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        hello.updatePriceOfPhoto(price);
    }
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Price getByPKPriceOfVideo(@PathParam("id") int id) throws MalformedURLException{
        HelloWorld hello = service.getHelloWorldImplPort();
        Price price = hello.getByPKPriceOfLens(id);
        return price;
    }
}
